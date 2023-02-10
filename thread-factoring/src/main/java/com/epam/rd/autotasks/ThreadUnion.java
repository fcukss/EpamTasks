package com.epam.rd.autotasks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public interface ThreadUnion extends ThreadFactory {
    int totalSize();

    int activeSize();

    void shutdown();

    boolean isShutdown();

    void awaitTermination();

    boolean isFinished();

    List<FinishedThreadResult> results();

    static ThreadUnion newInstance(String name) {

        return new ThreadUnionImpl(name);
    }
}