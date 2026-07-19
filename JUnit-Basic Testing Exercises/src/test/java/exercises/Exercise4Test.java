package exercises;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Exercise4Test {

    Student student;

    @Before
    public void setUp(){

        student = new Student("Lohit");

        System.out.println("Setup Done");

    }

    @Test
    public void testStudentName(){

        assertEquals("Lohit", student.getName());

    }

    @After
    public void tearDown(){

        student = null;

        System.out.println("Cleanup Done");

    }

}