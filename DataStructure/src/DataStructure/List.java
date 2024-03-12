package DataStructure;

import java.util.Arrays;

public class List<T> extends Container {
    private Object[] array;
    public List() {
        this.array = new Object[1];
        this.size = 0;
    }
    public List(List<T> list) {
        this((T[]) list.array, list.getSize());
    }
    public List(java.util.List<T> list) {
        this();
        for (T t : list) {
            add(t);
        }
    }
    public List(T[] array) {
        this(array, array.length);
    }
    private List(T[] array, int size) {
        this.array = new Object[array.length];
        this.size = size;
        System.arraycopy(array, 0, this.array, 0, this.size);
    }
    public T get(int index) {
        return (T) array[index];
    }
    public void set(int index, T val) {
        lengthCheck(index);
        array[index] = val;
    }
    public void insert(int index, T val) {
        lengthCheck(index);
        expand();
        T current = null;
        for (int i = index; i < size; i++) {
            Object temp = array[i];
            if (current != null)
                array[i] = current;
            current = (T) temp;
        }
        array[index] = val;
        size ++;
    }
    public int indexOf(T val) {
        for (int i = 0; i < this.size; i++) {
            if (val.equals(array[i])) return i;
        }
        return -1;
    }
    public int indexOf(int startIndex, T val) {
        lengthCheck(startIndex);
        for (int i = startIndex; i < this.size; i++) {
            if (val.equals(array[i])) return i;
        }
        return -1;
    }
    public boolean contains(T val) {
        return indexOf(val) != -1;
    }
    public boolean contains(int startIndex, T val) {
        lengthCheck(startIndex);
        return indexOf(startIndex, val) != -1;
    }
    public void add(T val) {
        expand();
        array[size] = val;
        size ++;
    }
    public void remove(T val) {
        int index = indexOf(val);
        lengthCheck(index);
        remove(index);
    }
    public void clear() {
        this.array = new Object[1];
        this.size = 0;
    }
    public int lastIndexOf(T val) {
        int lastIndex = -1;
        int currentIndex = 0;
        while ((currentIndex = indexOf(currentIndex, val)) != -1) {
            lastIndex = currentIndex;
            currentIndex ++;
        }
        return lastIndex;
    }
    public void removeAll(T val) {
        int index = 0;
        while ((index = indexOf(val)) != -1) {
            remove(index);
        }
    }
    public List<T> subList(int startIndex, int endIndex) {
        List<T> newList = new List<>();
        for (int i = startIndex; i < endIndex; i++) {
            newList.add(get(i));
        }
        return newList;
    }
    public void setAll(T beforeVal, T afterVal) {
        int index = 0;
        while ((index = indexOf(index, beforeVal)) != -1) {
            set(index, afterVal);
            index++;
        }
    }
    public void addAll(List<T> list) {
        for (int i = 0; i < list.getSize(); i++) {
            add(list.get(i));
        }
    }
    public void addAll(T[] array) {
        for (T t : array) {
            add(t);
        }
    }
    public boolean equals(List<T> list) {
        return list.array == this.array;
    }
    public void remove(int index) {
        lengthCheck(index);
        for (int i = index; i < size; i++) {
            if (array.length <= i - 1) {
                array[i] = null;
                break;
            }
            if (array.length != i + 1) {
                array[i] = array[i + 1];
            } else {
                array[i] = null;
            }
        }
        size --;
        shrink();
    }
    public T at(int index) {
        return get(index);
    }
    private boolean isFull() {
        return size == array.length;
    }

    private void lengthCheck(int index) {
        if (index < 0) throw new IndexOutOfBoundsException("Index less than 0");
        if (index >= size) throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
    }

    private void expand() {
        if (!isFull()) return;
        Object[] newArray = new Object[array.length << 1];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    private void shrink() {
        if (size << 1 > array.length - 1) return;
        Object[] newArray = new Object[array.length >> 1];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
    public String toString() {
        return Arrays.toString(array).replaceAll(", null", "");
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public int getLastIndex() {
        return size - 2;
    }

    public int getNextIndex() {
        return size - 1;
    }
}
