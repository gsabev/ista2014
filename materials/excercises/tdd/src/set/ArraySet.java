package set;

public class ArraySet {

	private int lastElementIndex = 0;
	private Object[] storage = new Object[10];

	public boolean add(Object element) {
		// TODO: Implement test first

		storage[lastElementIndex++] = element;
		return true;
	}

	public boolean contains(Object element) {
		// TODO: Implement addExistingElement test first

		return true;
	}

	public int size() {
		return lastElementIndex;
	}
}