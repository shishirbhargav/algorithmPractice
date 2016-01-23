package com.deb.geeksforgeeks.crackingcoding.ch01.ch01;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by deb on 10/15/15.
 */
public class ZeroMatrix {
    int[][] matrix;
    int[][] resultmatrix;
    int size;
    Set<Integer> visitedCols;
    Set<Integer> visitedRows;


    ZeroMatrix(int size){
        Random random = new Random(System.currentTimeMillis());
        this.size = size;
        matrix = new int[size][size];
        for (int i =0; i < size ; i++){
            for (int j =0; j < size; j++){
                matrix[i][j] = random.nextInt(20);
            }
        }
        visitedCols = new HashSet<Integer>();
        visitedRows = new HashSet<Integer>();
    }


    void printMatrix(){

        for (int i =0; i < size ; i++){
            for (int j =0; j < size; j++){
                System.out.print(matrix[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    void makeZeros(){
        for (int col : visitedCols){
            for(int i = 0; i< size; i++){
                matrix[i][col] = 0;
            }
        }
        for (int row : visitedRows){
            for(int i = 0; i< size; i++){
                matrix[row][i] = 0;
            }
        }

    }
    void setZeros(){
        for(int i =0 ; i < size && !visitedRows.contains(i); i++) {
            for(int j =0 ; j < size && !visitedCols.contains(i); j++) {
                if (matrix[i][j] == 0)
                {
                    visitedRows.add(i);
                    visitedCols.add(j);
                    continue;
                }
            }

//            printMatrix();
        }
        makeZeros();
    }


    public static void  main(String args[]){
        ZeroMatrix zeroMatrix = new ZeroMatrix(8);
        System.out.println("Initial Matrix");
        zeroMatrix.printMatrix();
        System.out.println("Starting to make zeros");
        zeroMatrix.setZeros();
        zeroMatrix.printMatrix();
    }
}
