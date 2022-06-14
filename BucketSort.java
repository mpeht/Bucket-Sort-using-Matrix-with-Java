/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketsort;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author mpeht
 */
public class BucketSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        int num = 0;
        System.out.println("Enter the size of vector:");
        num = sc.nextInt();

        int vector[] = new int[num];
        System.out.println("Enter the values for vector fill: ");

        for (int i = 0; i < num; i++) {
            vector[i] = sc.nextInt();
        }

        bucketSort(vector);
        

    }

    public static void bucketSort(int[] vector) {

        int i = 0, k = 0, j = 0, l = 0, index, temp;
        int size = vector.length;
        int min = -1;

        int max = getMaxNumber(vector);

        int numberOfBuckets = max / (vector.length);
        int[][] bucket = new int[vector.length][numberOfBuckets];
        int[] vector01 = new int[size];

        for (i = 0; i < vector.length; i++) {
            for (k = 0; k < numberOfBuckets; k++) {
                bucket[i][k] = Integer.MIN_VALUE;
            }
        }
        j = 0;
        while (l < vector.length) {
            index = vector[l] / numberOfBuckets;
            k = 0;
            if (bucket[index - 1][k] == Integer.MIN_VALUE) {
                bucket[index - 1][k] = vector[j];
                j++;
                k++;
            } else {
                bucket[index - 1][++k] = vector[j];
            }
            l++;

        }

        k = 0;
        for (i = 0; i < vector.length; i++) {
            for (j = 0; j < numberOfBuckets; j++) {
                if (bucket[i][j] != Integer.MIN_VALUE) {
                    temp = bucket[i][j];
                    vector01[k] = temp;
                    k++;
                }
            }
        }
        toPrint(vector01);
    }

    public static int getMaxNumber(int[] vector) {
        int i;
        int max = Integer.MIN_VALUE;

        for (i = 0; i < vector.length; i++) {
            if (max < vector[i]) {
                max = vector[i];
            }
        }
        return max;

    }

    public static void toPrint(int[] vector) {

        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }
    }

}
