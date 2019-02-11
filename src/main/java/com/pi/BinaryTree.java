package com.pi;

import java.util.ArrayList;

public class BinaryTree {

    private PrimeNumberService primeNumberService = PrimeNumberService.get();

    //Bu kısımda Number nesnesi için bir kök ve komşu toplamları için bir ArrayList tanımlıyoruz
    Number root;
    ArrayList<Integer> sums = new ArrayList<>();
    ArrayList<Integer> sums2 = new ArrayList<>();

    //Bu kısımda yollarımızı oluşturuyoruz
    void printPaths(Number node, int capacity) {
        int path[] = new int[1000];
        printPathsRecur(node, path, 0, capacity);
    }

    //Bu kısımda her komşu için ayrı bir yol oluşturuyoruz bunun için özyinelemeli bir fonksiyon oluşturdum.
    void printPathsRecur(Number node, int path[], int pathLen, int capacity) {
        if (node == null) {
            return;
        }
        path[pathLen] = node.getValue();
        pathLen++;

        if (node.getAdjacents().isEmpty()) {
            sumArray(path, pathLen, capacity);
        } else {
            if (node.getAdjacents().size() == 2) {
                printPathsRecur(node.getAdjacents().get(0), path, pathLen, capacity);
                printPathsRecur(node.getAdjacents().get(1), path, pathLen, capacity);
            }
        }
    }

    //Bu kısımda yollarımızı topluyoruz ve tanımladığımız ArrayList'e atıyoruz.
    void sumArray(int ints[], int len, int capacity) {
        int sum = 0, lent=0;
        for (int i = 0; i < len; i++) {
            if (primeNumberService.isNumberPrimeNumber(ints[i]) == true) {
                break;
            }
            System.out.print(ints[i] + " -> ");
            sum = sum + ints[i];
        }
        System.out.print("  Toplam : " + sum);
        System.out.println();
        sum = 0;
        for (int j = 0; j < len; j++) {
            if (primeNumberService.isNumberPrimeNumber(ints[j]) == true) {
                lent = len;
                break;
            }
            sum = sum + ints[j];
        }
        sums.add(sum);
        sum=0;
        if(lent == 0){
            for (int i = 0; i < len; i++) {
                System.out.println(ints[i] + " -> ");
                sum=sum+ints[i];
            }
            System.out.print("  Toplam : " + sum);
        System.out.println();
        }
        sums2.add(sum);
    }

}
