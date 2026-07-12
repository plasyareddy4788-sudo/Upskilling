package exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class Exercise1Test {

    @Test
    void testMockRepository(){

        Repository repository = mock(Repository.class);

        when(repository.getData()).thenReturn("Mock Data");

        Service service = new Service(repository);

        String result = service.processData();

        assertEquals("Processed Mock Data",result);

    }

}