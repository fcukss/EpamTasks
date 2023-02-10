package com.epam.rd.autotasks;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        long map = 0b11110000_00000111_00000000_00110000_00000010_01000000_00000000_00000000L;
        Battleship8x8 battle = new Battleship8x8(map);
     //   System.out.println(battleship8x8.shoot("D6"));
  List shots = List.of("A1", "A2", "A3", "A4");

 //  shots.forEach(shot -> battle.shoot((String) shot));

   System.out.println(battle.shoot("A1"));
        System.out.println(battle.state());


    }
}
