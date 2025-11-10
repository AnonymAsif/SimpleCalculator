package com.example.mycalculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class MathEvalTest {
    @Test
    public void eval_test() {

        // ADDITION TESTS

        // Basic Positive Numbers
        assertEquals(5.0, Double.parseDouble(MathEval.eval("2+3")), 0.0001);
        assertEquals(6.0, Double.parseDouble(MathEval.eval("2+2+2")), 0.0001);

        // Addition with 0
        assertEquals(2490.0, Double.parseDouble(MathEval.eval("2490+0")), 0.0001);
        assertEquals(684.0, Double.parseDouble(MathEval.eval("600+84+0")), 0.0001);

        // Negative Numbers
        assertEquals(-10.0, Double.parseDouble(MathEval.eval("-2+-8")), 0.0001);
        assertEquals(2.0, Double.parseDouble(MathEval.eval("5+-3")), 0.0001);

        // Large Numbers
        assertEquals(1000000, Double.parseDouble(MathEval.eval("999999+1")), 0.0001);

        // With Decimals
        assertEquals(3.8, Double.parseDouble(MathEval.eval("1.5+2.3")), 0.0001);
        assertEquals(0.3, Double.parseDouble(MathEval.eval("0.1+0.2")), 0.0001);

        // Mixed Number Types
        //assertEquals("0.0003", Double.parseDouble(MathEval.eval("0.0001+0.0002")), 0.0001);
        assertEquals(8.5, Double.parseDouble(MathEval.eval("5+3.5")), 0.0001);
        assertEquals(2.5, Double.parseDouble(MathEval.eval("-2.5+5")), 0.0001);

        // Negatives and Decimals
        assertEquals(-4.6, Double.parseDouble(MathEval.eval("-1.2+-3.4+1-1")), 0.0001);
        assertEquals(2.2, Double.parseDouble(MathEval.eval("-1.2+3.4")), 0.0001);

        // Very Small Decimals
        assertEquals(0.0003, Double.parseDouble(MathEval.eval("0.0001+0.0002")), 0.0001);
        assertEquals(5, Double.parseDouble(MathEval.eval("5 + 0.0001")), 0.0001);
        assertEquals(-0.0002, Double.parseDouble(MathEval.eval("0.0001-0.0003")), 0.0001);


        // MULTIPLICATION TESTS

        // Basic Positive Numbers
        assertEquals(6.0, Double.parseDouble(MathEval.eval("2*3")), 0.0001);
        assertEquals(56, Double.parseDouble(MathEval.eval("7*8")), 0.0001);

        // 0 and 1 Multiplication
        assertEquals(0, Double.parseDouble(MathEval.eval("0*5")), 0.0001);
        assertEquals(23930, Double.parseDouble(MathEval.eval("23930*1")), 0.0001);

        // Negative Numbers
        assertEquals(6.0, Double.parseDouble(MathEval.eval("-2*-3")), 0.0001);
        assertEquals(-20, Double.parseDouble(MathEval.eval("-4*5")), 0.0001);

        // Large Numbers
        assertEquals(1000000, Double.parseDouble(MathEval.eval("1000*1000")), 0.0001);
        assertEquals(4294967, Double.parseDouble(MathEval.eval("4294967*1")), 0.0001);

        // Decimals
        assertEquals(3.0, Double.parseDouble(MathEval.eval("1.5*2")), 0.0001);
        assertEquals(-0.5, Double.parseDouble(MathEval.eval("1.25*-0.4")), 0.0001);

        // Mixed Types
        assertEquals(12.5, Double.parseDouble(MathEval.eval("5*2.5")), 0.0001);
        assertEquals(-7.5, Double.parseDouble(MathEval.eval("-3*2.5")), 0.0001);

        // Very Small Decimals
        assertEquals(0.00000002, Double.parseDouble(MathEval.eval("0.0001*0.00002")), 0.0001);
        assertEquals(0.00000004, Double.parseDouble(MathEval.eval("0.0002*0.0002")), 0.0001);

        // Negative and Decimals
        assertEquals(1, Double.parseDouble(MathEval.eval("-2*-0.5")), 0.0001);
        assertEquals(-0.75, Double.parseDouble(MathEval.eval("-3*0.25")), 0.0001);


        // DIVISION TESTS
        assertEquals(0.4, Double.parseDouble(MathEval.eval("2/5")), 0.0001);
        assertEquals(2.0/3, Double.parseDouble(MathEval.eval("2/3")), 0.0001);
        assertEquals(2.3, Double.parseDouble(MathEval.eval("23/10")), 0.0001);

        // Invalid Inputs
        assertEquals("Error", MathEval.eval("a * 0.5"));
        assertEquals("4a", MathEval.eval("a*0.4"));
    }

}