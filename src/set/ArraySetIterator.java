package set;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArraySetIterator implements Iterator {

    private ArraySet set;
    private int iteratorIndex = 0;
    private Object lastElement;

    ArraySetIterator(ArraySet examSet) {
        this.set = examSet;
    }

    @Override
    public boolean hasNext() {
        return iteratorIndex < set.size();
    }

    @Override
    public Object next() {
        if (iteratorIndex + 1 > set.size()) {
            throw new NoSuchElementException();
        }
        lastElement = set.get(iteratorIndex++);
        return lastElement;
    }

    @Override
    public void remove() {
        set.remove(lastElement);
    }
}
