package com.deb.geeksforgeeks.crackingcoding.ch01.ch01;

import java.util.Random;
/**
 * Created by deb on 10/15/15.
 */
public class RotateSquare {
    int[][] matrix;
    int size;

    RotateSquare(int size){
        Random random = new Random(731263716);
        this.size = size;
        matrix = new int[size][size];
        for (int i =0; i < size ; i++){
            for (int j =0; j < size; j++){
                matrix[i][j] = random.nextInt(10);
            }
        }
    }


    void printMatrix(){

        for (int i =0; i < size ; i++){
            for (int j =0; j < size; j++){
                System.out.print(matrix[i][j]);
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    void rotateLeft(){
        for(int i =0 ; i < size/2; i++) {
            rotateHelper(i);
            System.out.println("Layer :" + i );
            printMatrix();
        }
    }
    void rotateHelper(int layer){

//        for (int i = layer; i < size-layer; i++){
            for (int i = 0; i < size-layer - layer-1; i++){


            // right = matrix[size - layer -1 - i ][layer]
            // top = matrix[layer ][layer + i]
            // left = matrix[layer + i ][size - layer -1]
            // bottom = matrix[size - layer -1 ] [size - layer -1 - i ]

            int temp = matrix[layer ][layer + i];

            // right to top
            matrix[layer ][layer + i] = matrix[size - layer - 1 - i ][layer];

            // bottom to right
            matrix[size - layer - 1 - i ][layer] = matrix[size - layer -1 ] [size - layer -1 - i ];

            // left to bottom
            matrix[size - layer -1 ] [size - layer -1 - i ] =  matrix[layer + i ][size - layer -1];

            // top to left
            matrix[layer + i ][size - layer -1] = temp;

        }
    }

    public static void  main(String args[]){
        RotateSquare rotateSquare = new RotateSquare(8);
        System.out.println("Initial Matrix");
        rotateSquare.printMatrix();
        System.out.println("Starting Rotate");
        rotateSquare.rotateLeft();
    }
}
