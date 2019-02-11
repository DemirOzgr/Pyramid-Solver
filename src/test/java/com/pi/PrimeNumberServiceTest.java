/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi;

import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author ozgur
 */
public class PrimeNumberServiceTest {
    
     PrimeNumberService primeNumberService;

    @Before
    public void setUp() {
        primeNumberService = PrimeNumberService.get();
    }

    @After
    public void tearDown() {
    }
    
      @Test
    // Asal olan bir sayi için asallık testimizi yapıyoruz.
    public void should_return_true() {
        boolean result = primeNumberService.isNumberPrimeNumber(3);
        assertTrue(result);

    }

    @Test
    // Asal olmayan bir sayı için asallık testimizi yapıyoruz.
    public void should_return_false() {
        boolean result = primeNumberService.isNumberPrimeNumber(6);
        assertFalse(result);
    }
    
}
