package DataStructure;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Supplier;

public class List<T> extends Container {
    private Object[] array;
    public List() {
        array = new Object[1];
        this.size = 0;
        System.out.println(array);
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
    public void add(T val) {
        expand();
        array[size] = val;
        size ++;
    }
    public void remove(int index) {
        lengthCheck(index);
        for (int i = index; i < size; i++) {
            if (array.length <= i - 1) {
                array[i] = null;
                break;
            }
            array[i] = array[i + 1];
        }
        size --;
        shrink();
    }

    private boolean isFull() {
        return size == array.length;
    }

    private void lengthCheck(int index) {
        if (index < 0) throw new IndexOutOfBoundsException("Index less than 0");
        if (index >= size) throw new IndexOutOfBoundsException("Index " + index + " for length " + size + " is invalid");
    }

    private void expand() {
        if (!isFull()) return;
        System.out.println("Expanding!");
        System.out.println(array.length);
        Object[] newArray = new Object[array.length << 1];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
        System.out.println(array.length);
    }

    private void shrink() {
        if (size << 1 > array.length - 1) return;
        System.out.println("Shrinking!");
        System.out.println(array.length);
        Object[] newArray = new Object[array.length >> 1];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
        System.out.println(array.length);
    }

    public boolean hasNext() {
        return size > 0;
    }

    public int getLast() {
        return size - 1;
    }

    public void printDebug() {
        System.out.println("Array : " + Arrays.toString(array));
    }

}
