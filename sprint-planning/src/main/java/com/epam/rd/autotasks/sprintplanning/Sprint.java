package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

public class Sprint {
    public int capacity;
    public int ticketsLimit;

    boolean bugs  =false;
    Ticket [] tickets;

    public Sprint(int capacity, int ticketsLimit) {
        this.capacity = capacity;
        this.ticketsLimit = ticketsLimit;
        tickets= new Ticket[ticketsLimit];

    }

    public boolean addUserStory(UserStory userStory) {
        for(int i=0; i<ticketsLimit;i++){
            tickets[i] = userStory;
        }

            if(userStory!=null && !userStory.isCompleted()) {
           return true;
       }else{
        return false;
       }

    }

    public boolean addBug(Bug bugReport) {
        UserStory userStory = new UserStory();
        if(!userStory.isCompleted()){
            bugs=true;
        }

            return bugs;
    }

    public Ticket[] getTickets() {

        return tickets;
    }

    public int getTotalEstimate() {
        int sum=0;
        Ticket ticket = new Ticket();
        sum += ticket.getEstimate();
        return sum;
    }
}
