package com.epam.rd.autotasks;

class Spiral {
    static int[][] spiral(int rows, int columns) {

        int[][] spiral = new int[rows][columns];

        int num = 1;
        int startCol = 0;
        int endCol = columns - 1;
        int startRow = 0;
        int endRow = rows - 1;


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                spiral[i][j] = 0;
            }
        }

        while (startCol <= endCol && startRow <= endRow) {

            for (int i = startCol; i <= endCol; i++) {
                spiral[startRow][i] = num;
                num++;
            }

            startRow++;
            for (int j = startRow; j <= endRow; j++) {
                spiral[j][endCol] = num;
                num++;
            }

            endCol--;
            for (int i = endCol; i >= startCol; i--) {
                spiral[endRow][i] = num;
                num++;
            }
            endRow--;
            for (int j = endRow; j >= startRow; j--) {
                spiral[j][startCol] = num;
                num++;
            }
            startCol++;
        }
        return spiral;
    }


}

