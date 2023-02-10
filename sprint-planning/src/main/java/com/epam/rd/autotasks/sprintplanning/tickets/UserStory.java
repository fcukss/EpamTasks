package com.epam.rd.autotasks.sprintplanning.tickets;

import java.util.Arrays;

public class UserStory extends Ticket {

    UserStory[] dependence;
    public UserStory(){
        comp = false;
    }

    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        this.dependence = dependsOn;
        comp = false;

    }

    public UserStory(int id, String name, int estimate, int id1) {
        super(id, name, estimate);
        comp = false;
    }

    @Override
    public void complete() {

        comp=true;
    }


    public UserStory[] getDependencies() {
        UserStory[] array =  dependence.clone();
        return array;
    }

    @Override
    public String toString() {

      return  "[US "+getId()+"] " + getName();
    }
}
