package ru.spbstu.telematics.java;

import java.util.*;

public class MyStack<T> implements Iterable<T> {

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

            @SuppressWarnings("unchecked")
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

    @SuppressWarnings("unchecked")
    public synchronized T peek() throws EmptyStackException {
        if (size > 0)
            return (T) arr[size - 1];
        else
            throw new EmptyStackException();
    }

    @SuppressWarnings("unchecked")
    public synchronized T pop() throws ArrayIndexOutOfBoundsException {
        if (size > 0)
            return (T) arr[--size];
        else
            throw new ArrayIndexOutOfBoundsException();
    }

    public T push(T element) {
        if (capacity == size) {
            capacity *= 2;
            Object[] arr1 =  new Object[capacity];
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
            if(i != size - 1)
                sb.append(arr[i] + ", ");
            else
                sb.append(arr[i]);
        }
        sb.append(']');
        return sb.toString();
    }

    public void clear(){
        Arrays.fill(arr, null);
        size = 0;
    }
    public int capacity(){return capacity;}

    public T get(int i){
        if (i<0||i>=size)
            throw new IndexOutOfBoundsException();
        return (T) arr[i];
    }

    public int size() {
        return size;
    }


}
