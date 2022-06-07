package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] input = {1,2,5,4,7,6,53,39,77};
        System.out.println("Before sorting : " + Arrays.toString(input));
        quicksort(input, 0,input.length-1);
        System.out.println(Arrays.toString(input));
    }

    static void quicksort(int[] arr, int low, int high){
        if(low < high){
            int p = partition(arr, low, high);
            quicksort(arr, low, p-1);
            quicksort(arr, p+1, high);
        }

    }

    static void swap(int[] arr, int low, int pivot){
        int tmp = arr[low];
        arr[low] = arr[pivot];
        arr[pivot] = tmp;
    }
    static int partition(int[] arr, int low, int high){
        int p = low, j;
        for(j=low+1; j <= high; j++)
            if(arr[j] < arr[low])
                swap(arr, ++p, j);

        swap(arr, low, p);
        return p;
    }

}
