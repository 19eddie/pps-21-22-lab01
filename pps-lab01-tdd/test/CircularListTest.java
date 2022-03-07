import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList circularList;

    @BeforeEach
    public void beforeEach(){
        circularList = new CircularListImpl();
    }

    @Test
    public void testAdd(){
        circularList.add(1);
        assertEquals(Optional.of(1), circularList.next());
    }

    @Test
    public void testSize(){
        circularList.add(0);
        circularList.add(1);
        assertEquals(2,circularList.size());
    }

    @Test
    public void testIsEmpty(){
        assertTrue(circularList.isEmpty());
    }

    @Test
    public void testNext(){
        circularList.add(1);
        circularList.add(2);
        assertEquals(Optional.of(1),circularList.next());
        assertEquals(Optional.of(2),circularList.next());
        assertEquals(Optional.of(1),circularList.next());
    }

    @Test
    public void testNextEmptyList(){
        assertEquals(Optional.empty(), circularList.next());
    }

    @Test
    public void testPrevious(){
        circularList.add(1);
        circularList.add(2);
        assertEquals(Optional.of(2),circularList.previous());
    }

    @Test
    public void testPreviousEmptyList(){
        assertEquals(Optional.empty(), circularList.previous());
    }

    @Test
    public void testReset(){
        circularList.add(1);
        circularList.reset();
        this.testIsEmpty();
    }

}
