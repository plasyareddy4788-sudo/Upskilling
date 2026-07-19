package exercises;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class Exercise3Test {

    @Test
    void testArgumentMatcher(){

        Calculator calculator = mock(Calculator.class);

        calculator.add(10,20);

        verify(calculator).add(anyInt(),anyInt());

    }

}