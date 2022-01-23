package ru.spbstu.telematics.java;

import java.util.*;

public class MyStack<T> implements Collection<T> {

    private Object[] arr;
    private int size;
    private int capacity;

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index;

            public boolean hasNext() {
                if (index < size)
                    return true;
                else
                    return false;
            }

            public void remove() {
                throw new UnsupportedOperationException("remove");
            }


            public T next() {
                return (T) arr[index++];
            }
        };
    }


    public MyStack() {
        size = 0;
        capacity = 5;
        arr = new Object[5];
    }

    boolean empty() {
        if (size == 0)
            return true;
        else
            return false;
    }

    public synchronized T peek() throws EmptyStackException {
        if (size > 0)
            return (T) arr[size - 1];
        else
            throw new EmptyStackException();
    }

    public synchronized T pop() throws ArrayIndexOutOfBoundsException {
        if (size > 0)
            return (T) arr[--size];
        else
            throw new ArrayIndexOutOfBoundsException();
    }

    public T push(T element) {
        if (capacity == size) {
            capacity *= 2;
            Object[] arr1 = new Object[capacity];
            if (size >= 0)
                System.arraycopy(arr, 0, arr1, 0, size);
            arr = arr1;
        }
        arr[size++] = element;
        return element;
    }


    public synchronized int search(T element) {
        for (int i = 0; i < size; i++)
            if (arr[i].equals(element))
                return size - i;
        return -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            if (i != size - 1)
                sb.append(arr[i] + ", ");
            else
                sb.append(arr[i]);
        }
        sb.append(']');
        return sb.toString();
    }

    public void clear() {
        Arrays.fill(arr, null);
        size = 0;
    }

    public int capacity() {
        return capacity;
    }

    public T get(int i) {
        if (i < 0 || i >= size)
            throw new IndexOutOfBoundsException();
        return (T) arr[i];
    }

    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) return false;
        for (int i = 0; i < size; i++) {
            if (arr[i].equals((T) o)) return true;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return arr;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        T1[] arr1;
        if (size <= a.length) {
            arr1 = a;
        } else {
            arr1 = (T1[]) new Object[size];
        }
        int i = 0;
        for (Object item : arr) {
            arr1[i++] = (T1) item;
        }
        return arr1;
    }

    @Override
    public boolean add(T t) {
        if (t == null)
            return true;
        return this.push(t) == t;
    }

    @Override
    public boolean remove(Object o) {
        int n = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(o)) {
                n = i;
                break;
            }
        }
        if (n != 0) {
            for (int i = n; i < size - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[size--] = null;
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c == null)
            return true;
        int i = 0;
        for (Object item : c) {
            if (this.contains(item)) {
                i++;
            }
        }
        return i == c.size();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T item : c) {
            this.add(item);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c == null)
            return false;
        int i = 0;
        for (Object item : c) {
            if (this.remove(item)) {
                i++;
            }
        }
        return i != 0;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        T[] arr1 = (T[]) new Object[capacity];
        int i = 0;
        for (Object item : c) {
            if (this.contains(item)) {
                arr1[i++] = (T) item;
            }
        }
        arr = arr1;
        size = i;
        return true;
    }
}

