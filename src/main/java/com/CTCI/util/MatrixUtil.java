package com.CTCI.util;


public class MatrixUtil {
    public static boolean matrixEquals(int[][] mat1, int[][] mat2){
        for(int i=0; i < mat1.length; i++){
            for(int p=0; p < mat1[i].length; p++){
                if(mat1[i][p] != mat2[i][p]) return false;
            }
        }
        return true;
    }

    public static void printMatrix(int[][] mat){
        for(int[] i : mat){
            String out = "";
            for(int p: i){
                out += p;
            }
            System.out.println(out);
        }
    }

    //Makes an empty matrix with the same dimensions as the input
    public static int[][] makeDummyMatrix(int[][] mat){
        int len = mat.length;
        int[][] output = new int[len][];
        for(int i =0; i<len; i++){
            output[i] = new int[mat[i].length];
        }

        return output;
    }
}
