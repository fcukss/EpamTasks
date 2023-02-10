package com.epam.rd.autotasks.sprintplanning.tickets;

public class Ticket {

    private int id;
    private String name;
    private int estimate;
    boolean comp = false;

    public Ticket(int id, String name, int estimate) {
        this.id = id;
        this.name = name;
        this.estimate = estimate;
    }

    public Ticket() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getEstimate() {
        return estimate;
    }


    public boolean isCompleted() {
        return comp;
    }

    public void complete() {
        comp = true;
    }
}
