package com.pi;

import java.util.ArrayList;


public class Number {
    
    private int value;
    private int x;
    private int y;
    private ArrayList<Number> adjacents = new ArrayList<>();
    
    public void addAdjacents(Number komsu) {
        adjacents.add(komsu);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ArrayList<Number> getAdjacents() {
        return adjacents;
    }

    public void setAdjacents(ArrayList<Number> adjacents) {
        this.adjacents = adjacents;
    }
}