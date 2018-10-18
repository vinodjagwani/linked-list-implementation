package exercise;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Please, add your tests here.
 */
public class LinkedListTest {

    private SimpleList<String> simpleList;

    @Before
    public void setUp() {
        simpleList = new LinkedList<>();
    }

    @After
    public void setDown() {
        simpleList = null;
    }

    @Test
    public void testLinkedListInit() {
        assertNotNull("Linkedlist must not be null", simpleList);
    }

    @Test
    public void testAdd() {
        simpleList.add("ABC");
        simpleList.add("DEF");
        simpleList.add("GHI");
        simpleList.add("JKL");
        simpleList.add("MNO");
        assertEquals("LinkedList size should be equal to", 5, simpleList.size());
        assertThat("Linked List should contain above values", simpleList,
                CoreMatchers.hasItems("ABC", "DEF", "GHI", "JKL", "MNO"));
    }

    @Test
    public void testSet() {
        simpleList.add("ABC");
        simpleList.add("DEF");
        assertThat("Linked List should contain above values", simpleList, CoreMatchers.hasItems("ABC", "DEF"));
        simpleList.set(0, "VINOD");
        simpleList.set(1, "KUMAR");
        assertEquals("Value set on index should be match", "VINOD", simpleList.get(0));
        assertEquals("Value set on index should be match", "KUMAR", simpleList.get(1));

    }

    @Test
    public void testRemove() {
        simpleList.add("VINOD");
        simpleList.add("KUMAR");
        simpleList.add("JAGWANI");
        simpleList.remove("KUMAR");
        assertEquals("LinkedList size should be equal to", 2, simpleList.size());
        assertThat("Linked List should able to removes the value", simpleList,
                CoreMatchers.hasItems("VINOD", "JAGWANI"));
    }

    @Test
    public void testGet() {
        simpleList.add("Vinod");
        simpleList.add("Jagwani");
        assertEquals("Value should be equal", "Jagwani", simpleList.get(0));
        assertEquals("Value should be equal", "Vinod", simpleList.get(1));

    }

    @Test
    public void testSize() {
        assertEquals("LinkedList size should be equal to", 0, simpleList.size());
        simpleList.add("test1");
        simpleList.add("test2");
        simpleList.add("test3");
        simpleList.add("test4");
        simpleList.add("test5");
        assertEquals("LinkedList size should be equal to", 5, simpleList.size());
    }

    @Test
    public void testIterator() {
        simpleList.add("1");
        simpleList.add("2");
        simpleList.add("3");
        simpleList.add("4");
        simpleList.add("5");
        assertEquals("LinkedList size should be equal to", 5, simpleList.size());
        Iterator<String> iterator = simpleList.iterator();
        assertTrue("Iterator.hasNext", iterator.hasNext());
        assertEquals("Iterator.next", "1", iterator.next());
        assertTrue("Iterator.hasNext", iterator.hasNext());
        assertEquals("Iterator.next", "2", iterator.next());
        assertTrue("Iterator.hasNext", iterator.hasNext());
        assertEquals("Iterator.next", "3", iterator.next());
        assertTrue("Iterator.hasNext", iterator.hasNext());
        assertEquals("Iterator.next", "4", iterator.next());
        assertTrue("Iterator.hasNext", iterator.hasNext());
        assertEquals("Iterator.next", "5", iterator.next());
        assertFalse("Iterator.hasNext", iterator.hasNext());
    }

}
