package exercises;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Exercise2Test {

    Calculator calculator = new Calculator();

    @Test
    public void testAddition(){

        assertEquals(10, calculator.add(5,5));

    }

    @Test
    public void testSubtraction(){

        assertEquals(2, calculator.subtract(5,3));

    }

    @Test
    public void testMultiplication(){

        assertEquals(20, calculator.multiply(5,4));

    }

}