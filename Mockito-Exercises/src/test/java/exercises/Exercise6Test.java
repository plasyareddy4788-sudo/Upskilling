package exercises;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class Exercise6Test {

    @Test
    void testOrder(){

        Logger logger = mock(Logger.class);

        logger.log("Start");

        logger.log("End");

        InOrder order = inOrder(logger);

        order.verify(logger).log("Start");

        order.verify(logger).log("End");

    }

}