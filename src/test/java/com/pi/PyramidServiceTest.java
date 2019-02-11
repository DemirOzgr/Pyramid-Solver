package com.pi;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ozgur
 */

//Burası test kısmımız, piramit için testler yapıyoruz.
public class PyramidServiceTest {

    PyramidService pyramidService;

    @Before
    public void setUp() {
        pyramidService = new PyramidService();
    }

    @After
    public void tearDown() {
    }

    @Test
    // Bu kısımda piramit için yazdırma testi yapıyoruz.
    public void can_print() {
        String matrix = Constants.SAMPLE_PYRAMID;
        Pyramid pyramid = new Pyramid(matrix);
        pyramid.print();
        assertTrue(true);
    }

    @Test
    // Doğru sonuçları test ettiğimiz kısım burası.
    // Her piramit için Constants bölümünde doğru cevaplar mevcut.
    // Constants.DEFAULT_PYRAMID kısmında, test etmek istediğimiz piramiti seçmeliyiz.
    // assertEquals(8823, sum) kısmında, sayı değerinin yerine test ettiğimiz piramitin cevabını yazmalıyız.
    public void should_returns_24() {
        String matrix = Constants.DEFAULT_PYRAMID;
        Pyramid pyramid = new Pyramid(matrix);
        int sum = pyramidService.maxSumOfNumber(pyramid);
        assertEquals(24, sum);
    }

  

}