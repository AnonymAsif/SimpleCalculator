package com.example.mycalculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class MathEvalTest {
    @Test
    public void eval_addition() {
        assertEquals("5.0", MathEval.eval("2+3"));
        assertEquals("6.0", MathEval.eval("2+2+2"));
        assertEquals("28.9", MathEval.eval("14+13+1.9"));
        assertEquals("37590", MathEval.eval("222+2783"));



    }

    @Test
    public void eval_multiplication() {
        assertEquals("12.0", MathEval.eval("3*4"));
        assertEquals("24.0", MathEval.eval("6*4"));
        assertEquals("42.0", MathEval.eval("6*7"));
        assertEquals("168.0", MathEval.eval("4*42"));
        assertEquals()



    }


}