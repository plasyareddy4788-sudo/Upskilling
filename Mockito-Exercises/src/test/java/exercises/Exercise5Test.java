package exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class Exercise5Test {

    @Test
    void testMultipleReturns(){

        ExternalApi api = mock(ExternalApi.class);

        when(api.getData())
                .thenReturn("First")
                .thenReturn("Second");

        assertEquals("First",api.getData());

        assertEquals("Second",api.getData());

    }

}