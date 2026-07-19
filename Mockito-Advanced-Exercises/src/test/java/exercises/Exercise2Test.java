package exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class Exercise2Test {

    @Test
    void testMockRestClient(){

        RestClient client = mock(RestClient.class);

        when(client.getResponse()).thenReturn("Mock Response");

        ApiService api = new ApiService(client);

        assertEquals("Fetched Mock Response",api.fetchData());

    }

}