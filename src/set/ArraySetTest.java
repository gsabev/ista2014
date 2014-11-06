package set;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArraySetTest {

    ArraySet set;

    @Before
    public void setup() {
        set = new ArraySet();
    }

    @Test
    public void testAddElement() {
        assertTrue(set.add("a"));
        assertTrue(!set.add("a"));
    }

    @Test(expected = NullPointerException.class)
    public void testAddNull() {
        set.add(null);
    }

    @Test
    public void testContainsElement() {
        assertTrue(!set.contains("a"));
        set.add("a");
        assertTrue(set.contains("a"));
    }

    @Test(expected = NullPointerException.class)
    public void testContainsNull() {
        set.contains(null);
    }

    @Test
    public void testFindElementIndexOnAdd() {
        assertEquals(-1, set.findElementIndex("a"));

        set.add("a");
        assertEquals(0, set.findElementIndex("a"));
        set.add("a");
        assertEquals(0, set.findElementIndex("a"));

        set.add("b");
        assertEquals(1, set.findElementIndex("b"));

        set.add("c");
        assertEquals(2, set.findElementIndex("c"));
    }

    @Test
    public void testFindElementIndexOnRemove() {
        set.add("a");
        set.add("b");
        set.add("c");

        set.remove("b");
        assertEquals(0, set.findElementIndex("a"));
        assertEquals(1, set.findElementIndex("c"));
    }

    @Test
    public void testResizeEmptyStorage() {
        int setSize = set.size();
        set.resizeStorage();
        assertEquals(setSize, set.size());
    }

    @Test
    public void testResizeStorage() {
        set.add("a");
        int setSize = set.size();
        set.resizeStorage();
        assertEquals(setSize, set.size());
    }

    @Test
    public void testEnsureCapacity() {
        for (int i = 1; i <= 20; i++) {
            set.add("element " + i);
        }

        assertEquals(20, set.size());
    }

    @Test
    public void testSizeOnAdd() {
        assertEquals(0, set.size());
        set.add("a");
        assertEquals(1, set.size());
        set.add("a");
        assertEquals(1, set.size());
        set.add("b");
        assertEquals(2, set.size());
    }

    @Test
    public void testRemove() {
        assertTrue(!set.remove("a"));
        set.add("a");
        set.add("b");
        assertTrue(set.remove("a"));
        assertTrue(!set.remove("a"));
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveNull() {
        set.remove(null);
    }

    @Test
    public void testRemoveAll() {
        for (int i = 1; i <= 10; i++) {
            set.add("element " + i);
            assertTrue(set.remove("element " + i));
        }
    }

    @Test
    public void testSizeOnRemove() {
        set.add("a");
        set.add("b");
        set.add("c");

        set.remove("a");
        assertEquals(2, set.size());
        set.remove("b");
        assertEquals(1, set.size());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetNonExistingElement() {
        set.get(10);
    }

    @Test
    public void testGetElement() {
        set.add("a");
        assertEquals("a", set.get(0));
    }

}
