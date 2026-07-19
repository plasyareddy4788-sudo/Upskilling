package exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class Exercise3Test {

    @Test
    void testFileIO(){

        MyFileReader reader = mock(MyFileReader.class);

        MyFileWriter writer = mock(MyFileWriter.class);

        when(reader.read()).thenReturn("Mock File Content");

        FileService service = new FileService(reader,writer);

        String result = service.processFile();

        assertEquals("Processed Mock File Content",result);

        verify(writer).write("Mock File Content");

    }

}