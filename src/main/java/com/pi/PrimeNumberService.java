/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi;

import java.util.HashMap;

/**
 *
 * @author ozgur
 */
public class PrimeNumberService {

    private static PrimeNumberService instance;
    private static final HashMap<Integer, Boolean> CACHE = new HashMap<>();

    private PrimeNumberService() {
        CACHE.clear();
    }

    public static PrimeNumberService get() {
        if (instance == null) {
            synchronized (PrimeNumberService.class) {
                if (instance == null) {
                    instance = new PrimeNumberService();
                }
            }
        }
        return instance;
    }

    //Bu kısımda sayının asallık kontrolünü yapıyoruz.
    public boolean isNumberPrimeNumber(Integer number) {
        if (CACHE.containsKey(number)) {
            return CACHE.get(number);
        } else {
            boolean primeNumber = false;
            int counter = 0;
            if (number <= 1) {
                primeNumber = false;
                CACHE.put(number, primeNumber);
                return primeNumber;
            }
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    counter++;
                }
            }
            if (counter > 0) {
                primeNumber = false;
                CACHE.put(number, primeNumber);
                return primeNumber;
            } else if (counter == 0) {
                primeNumber = true;
                CACHE.put(number, primeNumber);
                return primeNumber;
            }
            CACHE.put(number, primeNumber);
            return primeNumber;
        }
    }
}
