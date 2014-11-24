package set;

import java.util.Arrays;

public class ArraySet {

	private int lastElementIndex = 0;
	private Object[] storage = new Object[10];

	public boolean add(Object element) {
		if (contains(element)) {
			return false;
		}

		ensureCapacity();

		storage[lastElementIndex++] = element;
		return true;
	}

	protected void ensureCapacity() {
		if (lastElementIndex >= storage.length - 1) {
			storage = resizeStorage();
		}
	}

	protected Object[] resizeStorage() {
		return Arrays.copyOf(storage, storage.length * 2 + 1);
	}

	public boolean contains(Object element) {
		return findElementIndex(element) != -1;
	}

	protected int findElementIndex(Object element) {
		if (element == null) {
			throw new NullPointerException();
		}

		for (int i = 0; i <= lastElementIndex; i++) {
			Object o = storage[i];
			if (element.equals(o)) {
				return i;
			}
		}

		return -1;
	}

	public int size() {
		return lastElementIndex;
	}

	public boolean remove(Object element) {
		int elementIndex = findElementIndex(element);
		if (elementIndex == -1) {
			return false;
		}

		removeElementFromStorage(elementIndex);

		lastElementIndex--;

		return true;
	}

	private void removeElementFromStorage(int elementIndex) {
		Object[] head = Arrays.copyOfRange(storage, 0, elementIndex);
		Object[] tail = Arrays.copyOfRange(storage, elementIndex + 1,
				storage.length);
		storage = Arrays.copyOf(head, head.length + tail.length);

		System.arraycopy(tail, 0, storage, head.length, tail.length);
	}
}
