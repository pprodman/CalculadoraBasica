package com.example.calculadora;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Clase de TEST para la clase Calculator
 * @author Pablo Rodríguez Manrique
 * @version 1.1 testing
 */
public class CalculatorTest {

    private Calculator Calculator;

    @Before
    public void setUp(){
        Calculator = new Calculator();
        System.out.println("Ready for testing");
    }

    @After
    public void tearDown(){
        System.out.println("Testing finished");
    }

    @Test
    public void testAdd2Operands() {
        int total = Calculator.calculate("5+3");
        assertEquals("X + Y operations not working correctly", 8, total);
        //The message here is displayed if the test fails
    }

    @Test
    public void testAdd1Operands() {
        int total = Calculator.calculate("4+3+1");
        assertEquals("+X operations not working correctly", 8, total);
        //The message here is displayed if the test fails
    }

    @Test
    public void testMult2Operands() {
        int total = Calculator.calculate("4*2");
        assertEquals("4 * X operations not working correctly", 8, total);
        //The message here is displayed if the test fails
    }

    @Test
    public void testMult3Operands() {
        int total = Calculator.calculate("3*2*8");
        assertEquals("X * Y * Z operations not working correctly", 48, total);
        //The message here is displayed if the test fails
    }

    @Test
    public void testMultAdd3Operands() {
        int total = Calculator.calculate("2*2+3");
        assertEquals("X * Y + Z operations not working correctly", 7, total);
        //The message here is displayed if the test fails
    }

    @Test
    public void testAddMult3Operands() {
        int total = Calculator.calculate("3+2*2");
        assertEquals("X + Y * Z operations not working correctly", 7, total);
        //The message here is displayed if the test fails
    }

    @Test
    public void testAddMultAdd4Operands() {
        int total = Calculator.calculate("3+2*2+4");
        assertEquals("X + Y * Z + A operations not working correctly", 11, total);
        //The message here is displayed if the test fails
    }
}