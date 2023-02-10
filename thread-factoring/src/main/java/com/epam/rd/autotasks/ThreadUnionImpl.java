package com.epam.rd.autotasks;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ThreadUnionImpl implements ThreadUnion {
    private int counter = 0;
    private String name;
    private final AtomicBoolean shutDown = new AtomicBoolean(true);

    private Map<String, Throwable> exceptions = new HashMap<>();
    private Map<String, Thread> threads = new HashMap<>();


    public ThreadUnionImpl(String name) {
        this.name = name;
    }

    @Override
    public  int totalSize() {
        return threads.size();
    }

    @Override
    public int activeSize() {
        int count = 0;
        for (Thread thread : threads.values()) {
            if (thread.isAlive()) {
                count++;
            }
        }
        return count;
    }


    @Override
    public void shutdown() {
        threads.values().forEach(Thread::interrupt);
        shutDown.getAndSet(false);
    }

    @Override
    public boolean isShutdown() {
     return !shutDown.get();
    }

    @Override
    public void awaitTermination() {
      threads.values().forEach(th->{
          try{
              th.join();
          }catch (InterruptedException e){
              e.printStackTrace();
          }
      });
    }

    @Override
    public  boolean isFinished() {
        return activeSize()==0 && !shutDown.get();
    }

    @Override
    public  List<FinishedThreadResult> results() {
        List<String> collect = threads.entrySet()
                .stream()
                .filter(threads -> !threads.getValue().isAlive()).map(Map.Entry::getKey).collect(Collectors.toList());
        return collect.stream().map(thName -> {
            Throwable throwable = exceptions.get(thName);
            if (throwable == null) {
                return new FinishedThreadResult(thName);
            }
            return new FinishedThreadResult(thName, throwable);
        }).collect(Collectors.toList());

    }

    @Override
    public  Thread newThread(Runnable r) {
        Thread thread = null;
        if (isShutdown()) {
            throw new IllegalStateException();
        }
        thread = new Thread(r, name + "-worker-" + counter++);

        thread.setUncaughtExceptionHandler((th, ex) -> {
            exceptions.put(th.getName(), ex);
        });
        threads.put(thread.getName(), thread);

        return thread;
    }
}

