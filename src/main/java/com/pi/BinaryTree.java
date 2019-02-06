package com.pi;

import java.util.ArrayList;

public class BinaryTree {
    
    //Bu kısımda Number nesnesi için bir kök ve komşu toplamları için bir ArrayList tanımlıyoruz
    Number root;
    ArrayList<Integer> sums = new ArrayList<>();
    
    //Bu kısımda yollarımızı oluşturuyoruz
    void printPaths(Number node) {
        int path[] = new int[1000];
        printPathsRecur(node, path, 0);
    }
    //Bu kısımda her komşu için ayrı bir yol oluşturuyoruz bunun için özyinelemeli bir fonksiyon oluşturdum.
    void printPathsRecur(Number node, int path[], int pathLen) {
        if (node == null) {
            return;
        }
        path[pathLen] = node.getValue();
        pathLen++;

        if (node.getAdjacents().isEmpty()) {
            sumArray(path, pathLen);
        } else {
            if (node.getAdjacents().size() == 2) {
                printPathsRecur(node.getAdjacents().get(0), path, pathLen);
                printPathsRecur(node.getAdjacents().get(1), path, pathLen);
            } else if (node.getAdjacents().size() == 3) {
                printPathsRecur(node.getAdjacents().get(0), path, pathLen);
                printPathsRecur(node.getAdjacents().get(1), path, pathLen);
                printPathsRecur(node.getAdjacents().get(2), path, pathLen);

            }
        }
    }
    //Bu kısımda yollarımızı topluyoruz ve tanımladığımız ArrayList'e atıyoruz.
    void sumArray(int ints[], int len) {
        int sum = 0;
        for (int j = 0; j < len; j++) {
            if (isNumberPrimeNumber(ints[j])==true) {
                break;
            }
            sum = sum + ints[j];
        }
        sums.add(sum);
    }
       //Bu kısımda sayının asallık kontrolünü yapıyoruz.
        public boolean isNumberPrimeNumber(Integer number) {
        boolean primeNumber = false;
        int counter = 0;
        if (number <= 1) {
            primeNumber = false;
            return primeNumber;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                counter++;
            }
        }
        if (counter > 0) {
            primeNumber = false;
            return primeNumber;
        } else if (counter == 0) {
            primeNumber = true;
            return primeNumber;
        }
        return primeNumber;
    }
}
