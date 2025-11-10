package com.example.mycalculator;

import static org.junit.Assert.*;
import org.junit.Test;

public class MainActivityTest {

    @Test
    public void evaluate_test() {
        // Static numbers - no trailing zeros!
        assertEquals("2", MainActivity.evaluate("002.000"));
        assertEquals("239377375", MainActivity.evaluate("239377375"));

        // Addition & Subtraction
        assertEquals("67", MainActivity.evaluate("32+35"));
        assertEquals("2.354", MainActivity.evaluate("2.001 + 0.353"));
        assertEquals("5", MainActivity.evaluate("2------3"));

        // Multiplication & Division
        assertEquals("2.51", MainActivity.evaluate("5/2 + 0.01"));
        assertEquals("6", MainActivity.evaluate("3 * 2.00000000000000001"));

        // Scientific Notation
        assertEquals("3E+16", MainActivity.evaluate("30000000000000000"));
        assertEquals("3.000000E+16", MainActivity.evaluate("30000000000000005"));

        // Broken - Throws Exception
        assertEquals("Error", MainActivity.evaluate("2**5"));
    }
}
