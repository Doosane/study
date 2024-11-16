package com.doosane.study01.week01.day4.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 이진 탐색을 이용한 찾기 연습
 */
public class BinarySearchIndex {
    static int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("target : ");
        int target = Integer.parseInt(br.readLine());

        Arrays.sort(numbers);

        int index = BSearch(numbers, target);

        printBinarySearchIndex(index);
    }

    static int BSearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    static void printBinarySearchIndex(int index) {
        if (index == -1) {
            System.out.println("target fail");
        } else {
            System.out.println("find target success in array: " + index);
        }
    }
}
