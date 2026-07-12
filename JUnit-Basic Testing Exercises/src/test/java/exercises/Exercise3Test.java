package exercises;

import org.junit.Test;

import static org.junit.Assert.*;

public class Exercise3Test {

    @Test
    public void testAssertions(){

        assertEquals(5,2+3);

        assertTrue(10>5);

        assertFalse(5>10);

        assertNull(null);

        assertNotNull(new Object());

    }

}