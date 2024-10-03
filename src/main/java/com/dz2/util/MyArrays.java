package com.dz2.util;

import java.util.Comparator;

public class MyArrays {

    private static final int MINIMUM_ELEMENTS_SORTED_ARRAY = 3;

    public static <E> void mergeSort(E[] sortedArray, int leftIndex, int rightIndex, Comparator<? super E> c){
        if (c == null){
            mergeSorted(sortedArray, leftIndex, rightIndex);
        }
        else {
            mergeSorted(sortedArray, leftIndex, rightIndex, c);
        }
    }
    // работает в 80% случаях ):):):):)):):): TEPER' 100%
    @SuppressWarnings("unchecked")
    private static void mergeSorted(Object[] sortedArray, int leftIndex, int rightIndex) {
        int length = rightIndex - leftIndex + 1;
        if (length < MINIMUM_ELEMENTS_SORTED_ARRAY) {
            for (int i = leftIndex; i <= rightIndex; i++) {
                for (int j = i; j > leftIndex && ((Comparable) sortedArray[j - 1]).compareTo(sortedArray[j]) >= 0; j--) {
                    swap(sortedArray, j, j - 1);
                }
            }
            return;
        }

        int middleIndex = (leftIndex + rightIndex) >>> 1;
        mergeSorted(sortedArray, leftIndex, middleIndex);
        mergeSorted(sortedArray, middleIndex + 1, rightIndex);

        int left = leftIndex;
        Object[] supps = new Object[length];

        for(int i = left, j=middleIndex+1, p=0; p<supps.length;){
            if(p==supps.length-1){
                if(j==rightIndex){
                    supps[p] = sortedArray[j];
                    break;
                }
                if(i==middleIndex){
                    supps[p] = sortedArray[i];
                    break;
                }
            }
            if (j<=rightIndex && ((Comparable) sortedArray[i]).compareTo(sortedArray[j]) >=0) {
                supps[p] = sortedArray[j];
                j++;
                p++;
            }
            else {
                if(i > middleIndex && p< supps.length){
                    supps[p] = sortedArray[j];
                    j++;
                    p++;
                    continue;
                }
                if(j> rightIndex && p< supps.length){
                    supps[p] = sortedArray[i];
                    i++;
                    p++;
                    continue;
                }
                supps[p] = sortedArray[i];
                p++;
                i++;
            }
        }
        System.arraycopy(supps,0, sortedArray, leftIndex, length);
    }

    @SuppressWarnings("unchecked")
    private static void mergeSorted(Object[] sortedArray, int leftIndex, int rightIndex, Comparator c) {
        int length = rightIndex - leftIndex + 1;
        if (length < MINIMUM_ELEMENTS_SORTED_ARRAY) {
            for (int i = leftIndex; i <= rightIndex; i++) {
                for (int j = i; j > leftIndex && c.compare(sortedArray[i], sortedArray[j]) >= 0; j--) {
                    swap(sortedArray, j, j - 1);
                }
            }
            return;
        }

        int middleIndex = (leftIndex + rightIndex) >>> 1;
        mergeSorted(sortedArray, leftIndex, middleIndex, c);
        mergeSorted(sortedArray, middleIndex + 1, rightIndex, c);

        int left = leftIndex;
        Object[] supps = new Object[length];

        for(int i = left, j=middleIndex+1, p=0; p<supps.length;){
            if(p==supps.length-1){
                if(j==rightIndex){
                    supps[p] = sortedArray[j];
                    break;
                }
                if(i==middleIndex){
                    supps[p] = sortedArray[i];
                    break;
                }
            }
            if (j<=rightIndex && c.compare(sortedArray[i], sortedArray[j]) >=0) {
                supps[p] = sortedArray[j];
                j++;
                p++;
            }
            else {
                if(i > middleIndex && p< supps.length){
                    supps[p] = sortedArray[j];
                    j++;
                    p++;
                    continue;
                }
                if(j> rightIndex && p< supps.length){
                    supps[p] = sortedArray[i];
                    i++;
                    p++;
                    continue;
                }
                supps[p] = sortedArray[i];
                p++;
                i++;
            }
        }
        System.arraycopy(supps,0, sortedArray, leftIndex, length);
    }


    private static void swap(Object[] x, int a, int b){
        Object t = x[a];
        x[a] = x[b];
        x[b] = t;
    }
}
