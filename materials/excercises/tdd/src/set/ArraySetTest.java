package set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ArraySetTest {

	ArraySet set;

	@Before
	public void setup() {
		set = new ArraySet();
	}

	@Test
	public void isEmpty() {
		assertEquals(0, set.size());
	}

	@Test
	public void addElement() {
		assertTrue(set.add("a"));
		assertEquals(1, set.size());
		assertTrue(set.contains("a"));
	}

	@Test
	public void addExistingElement() {
		set.add("a");
		assertFalse(set.add("a"));
	}

}
