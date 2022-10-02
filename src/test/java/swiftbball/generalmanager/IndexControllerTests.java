package swiftbball.generalmanager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class IndexControllerTests {
    @Test
    void testIndex() {
       assertEquals("Hello World", new IndexController().index());
    }
}
