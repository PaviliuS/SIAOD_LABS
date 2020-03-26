package com.company;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static int input() {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        return num;
    }

    public static void stepSort(int[] arr){
        long count = 0;
        for (int i=1; i<arr.length; i++){
            int j=i-1;
            while (j>=0 && arr[j]>arr[j+1]){
                int temp = arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
                j--;
                count++;
            }
        }

        System.out.println("\r\nStepSort:");
        System.out.println("Количество перестановок: " + count);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high, long count){
        if (arr == null || arr.length == 0)
            return;

        if (low >= high)
            return;

        // выбираем pivot средний идентификатор массива
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // левая граница left < pivot и right > pivot правая граница
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
                count++;
            }
        }

        // рекурсив
        if (low < j){
            quickSort(arr, low, j, count);
        }
        else{
            if (high > i){
                quickSort(arr, i, high, count);
            }
            else{
                System.out.println("\r\nQuickSort:");
                System.out.println("Количество перестановок: " + count);
                System.out.println(Arrays.toString(arr));
            }
        }
    }

    public static void standartSort(int[] arr)
    {
        Arrays.sort(arr);
        System.out.println("\r\nStandartSort:");
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        long start;
        long finish;
        long timeConsumedMillis;

        System.out.println("Введите длину массива:");
        int [] array;
        array = new int[input()];

        for (int i=0; i<array.length; i++){
            array[i]=(int) Math.round(Math.random() * 100);
        }
        int [] stable_1 = array;
        int [] stable_2 = array;
        int [] stable_3 = array;

        System.out.println("\r\nИсходный массив:");
        System.out.println(Arrays.toString(array));

        start = System.nanoTime();
        stepSort(stable_1);
        finish = System.nanoTime();
        timeConsumedMillis = finish - start;
        System.out.println("Время выполнения: " + timeConsumedMillis);

        long count=0;
        start = System.nanoTime();
        quickSort(stable_2, 0, array.length - 1, count);
        finish = System.nanoTime();
        timeConsumedMillis = finish - start;
        System.out.println("Время выполнения: " + timeConsumedMillis);

        start = System.nanoTime();
        standartSort(stable_3);
        finish = System.nanoTime();
        timeConsumedMillis = finish - start;
        System.out.println("Время выполнения: " + timeConsumedMillis);

    }
}
