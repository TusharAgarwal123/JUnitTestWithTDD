package com.unitTestDemo.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FizzBuzzTest {

    @Test
    @DisplayName("Divisible by Three")
    @Order(1)
    //@DisabledOnOs(OS.WINDOWS)
    void testForDivisibleByThree(){
        String expected="Fizz";
        assertEquals(expected,FizzBuzz.compute(3),"Should return Fizz");
    }

    @Test
    @DisplayName("Divisible by Five")
    @Order(2)
    void testForDivisibleByFive(){
        String expected="Buzz";
        assertEquals(expected,FizzBuzz.compute(5),"Should return Buzz");
    }

    @Test
    @DisplayName("Divisible by Three and Five")
    @Order(3)
    void testForDivisibleByThreeAndFive(){
        String expected="FizzBuzz";
        assertEquals(expected,FizzBuzz.compute(15),"Should return FizzBuzz");
    }

    @Test
    @DisplayName("Not Divisible by Three or Five")
    @Order(4)
    void testForNotDivisibleByThreeAndFive(){
        String expected="2";
        assertEquals(expected,FizzBuzz.compute(2),"Should return same number");
    }

    @ParameterizedTest(name="value={0}, expected={1}")
    @DisplayName("Testing with small data file")
    @CsvFileSource(resources = "/small-text-data.csv")
    @Order(5)
    void testSmallDataFile(int value,String expected){
        assertEquals(expected,FizzBuzz.compute(value));
    }
}
