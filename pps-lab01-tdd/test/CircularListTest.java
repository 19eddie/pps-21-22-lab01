import lab01.tdd.CircularList;
import lab01.tdd.SimpleCircularList;
import org.junit.jupiter.api.*;


/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList circularList;

    @BeforeEach
    public void beforeEach(){
        circularList = new SimpleCircularList();
    }

    @Test
    public void testIsEmpty(){
        Assertions.assertTrue(circularList.isEmpty());
    }

}
