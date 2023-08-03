package Bubblesort;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Bubblesort {

    public static int[] inputArray() {
        int size = 0;
        int count = 5;
        System.out.println("Enter number of array: ");
        Scanner sc = new Scanner(System.in);
        while (true) {
        try {
            do {
                size = sc.nextInt();
                if(size < 0) System.out.println("Entered number must be positive");
            } while (size < 0);
            break;
        } catch (InputMismatchException e) {
            System.out.println("Is not a number");
            count++;
        }
        } 
        Random rd = new Random();
        int[] arr = new int[size];
        for (int i = 0; i <= size - 1; i++) {
            arr[i] = rd.nextInt(size);
        }
        return arr;
    }

    public static void printArray(int arr[]) {
        int[] arr1 = arr.clone();
        System.out.print("Unsorted array: ");
        System.out.print(Arrays.toString(arr));
        System.out.println("");
        System.out.print("Sorted array: ");
        bubbleSort(arr);
        System.out.print(Arrays.toString(arr));
        System.out.println("");
        System.out.print("Edited sorted array: ");
        bubbleSortEdit(arr1);
        System.out.print(Arrays.toString(arr1));
        System.out.println("");
    }

    public static int[] bubbleSort(int arr[]) {
        int i = 0;
        int size = arr.length;
        for (i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int swap = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = swap;
                }
            }
        }
        System.out.println("Rounds: " + (i + 1));
        return arr;
    }

    public static int[] bubbleSortEdit(int arr[]) {
        int i = 0;
        int size = arr.length;
        for (i = 0; i < size - 1; i++) {
            int flag = 0;
            for (int j = 0; j < size - i - 2; j++) {
                if (arr[j] > arr[j + 1]) {
                    int swap = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = swap;
                    flag = 1;
                }
            }
            if (flag == 0) {
                break;
            }
        }
        System.out.println("Rounds: " + (i + 1));
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = inputArray();
        printArray(arr);
    }
}
