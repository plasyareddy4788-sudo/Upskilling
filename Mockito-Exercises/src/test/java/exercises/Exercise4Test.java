package exercises;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class Exercise4Test {

    @Test
    void testVoidMethod(){

        Logger logger = mock(Logger.class);

        doNothing().when(logger).log(anyString());

        logger.log("Hello");

        verify(logger).log("Hello");

    }

}