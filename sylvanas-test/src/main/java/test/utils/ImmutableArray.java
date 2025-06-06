package test.utils;

import java.util.ArrayList;
import java.util.List;

public class ImmutableArray {
    private List<String> array;
    private boolean mutable;

    public ImmutableArray() {
        this.array = new ArrayList<>();
        this.mutable = true;
    }

    public void  insert(int index, String value) {
        if (!mutable) {
            throw new RuntimeException("Array is immutable and cannot be modified.");
        }
        if (index > array.size()) {
            throw new IndexOutOfBoundsException("Index out of range.");
        }
        array.add(index, value);
    }

    public String get(int index) {
        if (index < 0 || index >= array.size()) {
            throw new IndexOutOfBoundsException("Index out of range.");
        }
        return array.get(index);
    }

    public void fix() {
        this.mutable = false;
    }

    public List<String> getArray() {
        return array;
    }

    public void setArray(List<String> array) {
        this.array = array;
    }

    public boolean isMutable() {
        return mutable;
    }

    public void setMutable(boolean mutable) {
        this.mutable = mutable;
    }
}
