package com.ana.binarysearch;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 15, 19, 45, 90};
        int target = 90;

        // if array contains the target, do the binary search
        if (IntStream.of(array).anyMatch(x -> x == target)) {
            String searchResult = binarySearch(array, target, 0);
            int targetIndex = Arrays.stream(array).boxed().toList().indexOf(target);
            System.out.println(searchResult + " at index " + targetIndex);
        } else { // if not, then just say it's not there
            System.out.printf("Number %s is not present in the array%n", target);
        }

    }

    public static String binarySearch(int[] array, int target, int counter) {
        String result = "";
        counter ++;

        // find where to split array in two
        int midPointIndex = (int) Math.round((array.length-1) / 2.0);

        // base case
        if (array[midPointIndex] == target) {
            result = "Number found in the array in %s tries".formatted(counter);
            return result;
        };

        if (array[midPointIndex] > target) {
            int[] newSearchRange = Arrays.copyOfRange(array, 0, midPointIndex);
            return binarySearch(newSearchRange, target, counter);
        }

        if (array[midPointIndex] < target) {
            int[] newSearchRange = Arrays.copyOfRange(array, midPointIndex, array.length);
            return binarySearch(newSearchRange, target, counter);
        }

        return "Something's not right";
    }
}