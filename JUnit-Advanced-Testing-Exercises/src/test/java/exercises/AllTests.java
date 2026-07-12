package exercises;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({

        EvenCheckerTest.class,
        SimpleTest.class

})

public class AllTests {
}