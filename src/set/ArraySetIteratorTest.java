package set;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArraySetIteratorTest {

    private ArraySet set;

    @Before
    public void setup() {
        set = new ArraySet();
    }

    @Test
    public void testIterator() {
        Object[] elements = {"a", "b", "c"};

        for (Object element : elements) {
            set.add(element);
        }

        assertEquals(elements.length, set.size());

        Iterator iterator = set.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Object next = iterator.next();
            assertEquals(elements[i++], next);
        }

        assertEquals(elements.length, i);
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorNextNoSuch() {
        set.add("a");

        Iterator iterator = set.iterator();
        iterator.next();
        iterator.next();
    }

    @Test
    public void testIteratorHasNext() {
        set.add("a");

        Iterator iterator = set.iterator();
        iterator.next();
        assertTrue(!iterator.hasNext());
    }

    @Test
    public void testIteratorRemove() {
        set.add("a");

        Iterator iterator = set.iterator();
        iterator.next();
        iterator.remove();

        assertTrue(!set.contains("a"));
    }
}
