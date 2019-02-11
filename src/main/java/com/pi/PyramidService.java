package com.pi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PyramidService {

    //Tüm yollara bakıp maksimum toplamı bulduğumuz kısım.
    //Piramit için komşuluk ilişkilerini burada belirliyoruz.
    public int maxSumOfNumber(Pyramid pyramid) {
        int result = 0, x = 0, y = 0, max = 0;;

        ArrayList<Number> numbers = new ArrayList<>();
        ArrayList<Number> adjacent = new ArrayList<>();

        for (int i = 0; i < pyramid.getCapacity(); i++) {
            for (int j = 0; j < pyramid.getCapacity(); j++) {
                Number anew = new Number();
                if (pyramid.getMatrix()[i][j] != null) {
                    anew.setValue(pyramid.getMatrix()[i][j]);
                    anew.setX(i);
                    anew.setY(j);
                    numbers.add(anew);
                    adjacent.add(anew);
                }
            }
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i).getX() == 0 && numbers.get(i).getY() == 0) {
                for (int k = 0; k < numbers.size(); k++) {
                    if (adjacent.get(k).getX() == x + 1 && adjacent.get(k).getY() == 0) {
                        numbers.get(i).addAdjacents(adjacent.get(k));
                    }
                    if (adjacent.get(k).getX() == x + 1 && adjacent.get(k).getY() == y + 1) {
                        numbers.get(i).addAdjacents(adjacent.get(k));
                    }
                }
            }
            if (numbers.get(i).getX() > 0 && numbers.get(i).getY() == 0) {
                for (int k = 0; k < numbers.size(); k++) {
                    if (adjacent.get(k).getX() == numbers.get(i).getX() + 1 && adjacent.get(k).getY() == 0) {
                        numbers.get(i).addAdjacents(adjacent.get(k));
                    }
                    if (adjacent.get(k).getX() == numbers.get(i).getX() + 1 && adjacent.get(k).getY() == numbers.get(i).getY() + 1) {
                        numbers.get(i).addAdjacents(adjacent.get(k));
                    }
                }
            }
            if (numbers.get(i).getX() > 0 && numbers.get(i).getY() > 0) {
                for (int k = 0; k < numbers.size(); k++) {
                    if (adjacent.get(k).getX() == numbers.get(i).getX() + 1 && adjacent.get(k).getY() == numbers.get(i).getY()) {
                        numbers.get(i).addAdjacents(adjacent.get(k));
                    }
                    if (adjacent.get(k).getX() == numbers.get(i).getX() + 1 && adjacent.get(k).getY() == numbers.get(i).getY() + 1) {
                        numbers.get(i).addAdjacents(adjacent.get(k));
                    }
                }
            }
        }
        BinaryTree tree = new BinaryTree();
        tree.printPaths(numbers.get(0));
        for (int i = 0; i < tree.sums.size(); i++) {
            if (tree.sums.get(i) > max) {
                max = tree.sums.get(i);
            }
        }
        System.out.println("max toplam: " + max);
        result = max;
        return result;
    }
}