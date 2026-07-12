package exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class Exercise4Test {

    @Test
    void testNetwork(){

        NetworkClient client = mock(NetworkClient.class);

        when(client.connect()).thenReturn("Mock Connection");

        NetworkService service = new NetworkService(client);

        String result = service.connectToServer();

        assertEquals("Connected to Mock Connection",result);

    }

}