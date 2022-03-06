import lab01.tdd.CircularList;
import lab01.tdd.SimpleCircularList;
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
        circularList = new SimpleCircularList();
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

}
