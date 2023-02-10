package com.epam.rd.autotasks;

import java.util.Scanner;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;


    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) {


        String A1 = "00000000";
        String B1 = "00000000";
        String C1 = "00000000";
        String D1 = "00000000";
        String E1 = "00000000";
        String F1 = "00000000";
        String G1 = "00000000";
        String H1 = "00000000";
        String res = null;


        Scanner scanner = new Scanner(shot);

        while (scanner.hasNext()) {
            String letter = scanner.nextLine();
            int num = 0;
            //int num = Integer.parseInt(String.valueOf(letter.charAt(1)));
            if (String.valueOf(letter.charAt(0)).equals("A")) {
                num = 1;
            }
            if (String.valueOf(letter.charAt(0)).equals("B")) {
                num = 2;
            }
            if (String.valueOf(letter.charAt(0)).equals("C")) {
                num = 3;
            }
            if (String.valueOf(letter.charAt(0)).equals("D")) {
                num = 4;
            }
            if (String.valueOf(letter.charAt(0)).equals("E")) {
                num = 5;
            }
            if (String.valueOf(letter.charAt(0)).equals("F")) {
                num = 6;
            }
            if (String.valueOf(letter.charAt(0)).equals("G")) {
                num = 7;
            }
            if (String.valueOf(letter.charAt(0)).equals("H")) {
                num = 8;
            }
            char ch = '1';
            int pos = num - 1;

            if (letter.contains("1")) {
                String A0 = A1.substring(0, pos) + ch + A1.substring(pos + 1);
                res = A0 + B1 + C1 + D1 + E1 + F1 + G1 + H1;
            }
            if (letter.contains("2")) {
                String B0 = B1.substring(0, pos) + ch + B1.substring(pos + 1);
                res = A1 + B0 + C1 + D1 + E1 + F1 + G1 + H1;
            }
            if (letter.contains("3")) {
                String C0 = C1.substring(0, pos) + ch + C1.substring(pos + 1);
                res = A1 + B1 + C0 + D1 + E1 + F1 + G1 + H1;
            }
            if (letter.contains("4")) {
                String D0 = D1.substring(0, pos) + ch + D1.substring(pos + 1);
                res = A1 + B1 + C1 + D0 + E1 + F1 + G1 + H1;
            }
            if (letter.contains("5")) {
                String E0 = E1.substring(0, pos) + ch + E1.substring(pos + 1);
                res = A1 + B1 + C1 + D1 + E0 + F1 + G1 + H1;
            }
            if (letter.contains("6")) {
                String F0 = F1.substring(0, pos) + ch + F1.substring(pos + 1);
                res = A1 + B1 + C1 + D1 + E1 + F0 + G1 + H1;
            }
            if (letter.contains("7")) {
                String G0 = G1.substring(0, pos) + ch + G1.substring(pos + 1);
                res = A1 + B1 + C1 + D1 + E1 + F1 + G0 + H1;
            }
            if (letter.contains("8")) {
                String H0 = H1.substring(0, pos) + ch + H1.substring(pos + 1);
                res = A1 + B1 + C1 + D1 + E1 + F1 + G1 + H0;
            }
            long dec = 0;

            if(!res.equals("1000000000000000000000000000000000000000000000000000000000000000")) {

                for (int i = 63; i >= 0; i--) {
                    if (res.charAt(i) == '1') {
                        dec += Math.pow(2, res.length() - i - 1);
                    }
                }
            }else{
                dec = -9223372036854775808L;
            }
            shots = shots | dec;
            System.out.println(shots);

        }
        String shipsMap = Long.toBinaryString(ships);
        if (shipsMap.length() == 63)
            shipsMap = "0" + Long.toBinaryString(ships);


        char ch = '1';
        int count = 0;
        for (int i = 0; i < shipsMap.length(); i++) {
            if ((res.charAt(i) == shipsMap.charAt(i)) && shipsMap.charAt(i) == ch)
                count++;
        }

        if (count > 0)
            return true;
        else
            return false;
    }


    public String state() {

        String shipsMap = Long.toBinaryString(ships);
        if (shipsMap.length() == 63)
            shipsMap = "0" + Long.toBinaryString(ships);



        String shotsMap = Long.toBinaryString(shots);



        while (shotsMap.length() < 64) {
            shotsMap = "0" + shotsMap;
        }


        for (int i = 0; i < shipsMap.length(); i++) {
            if ((shotsMap.charAt(i) == '1' && shipsMap.charAt(i) == '1'))
                shipsMap = shipsMap.substring(0, i) + '☒' + shipsMap.substring(i + 1);

            else if (shotsMap.charAt(i) == '1' && shipsMap.charAt(i) == '0') {
                shipsMap = shipsMap.substring(0, i) + '×' + shipsMap.substring(i + 1);
            }
        }

        for (int i = 0; i < shipsMap.length(); i++) {
            if (shipsMap.charAt(i) == ('0')) {
                shipsMap = shipsMap.replace('0', '.');
            }
            if (shipsMap.charAt(i) == ('1')) {
                shipsMap = shipsMap.replace('1', '☐');
            }
        }
        int index = 8;
        for (int i = 0; i < shipsMap.length(); i++) {
            if (i == index) {
                shipsMap = new StringBuilder(shipsMap).insert(index, "\n").toString();
                index += 8 + 1;
            }
        }
        return shipsMap.strip();
    }
}
