package exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class Exercise7Test {

    @Test
    void testVoidException(){

        Logger logger = mock(Logger.class);

        doThrow(new RuntimeException("Error"))
                .when(logger)
                .log(anyString());

        assertThrows(RuntimeException.class, () -> {

            logger.log("Hello");

        });

    }

}