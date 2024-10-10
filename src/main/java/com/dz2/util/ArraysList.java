package com.dz2.util;

import java.util.*;

public class ArraysList<E> implements List<E> {

    private final static int DEFAULT_V = 10;

    private final static Object[] DEFAULT_ARRAY = {};

    private final static Object[] DEFAULT_ARRAY_DATA = {};

    private Object[] arrayData;

    private int size;

    public ArraysList() {
        this.arrayData = DEFAULT_ARRAY;
    }

    public ArraysList(int initial_V){
        if(initial_V > 0){
            this.arrayData = new Object[initial_V];
        }
        else if (initial_V == 0){
            this.arrayData = DEFAULT_ARRAY_DATA;
        }
        else throw new IllegalArgumentException("Illegal Capacity: "+
                    initial_V);
    }

    public ArraysList(Collection<? extends E> collection){
        Object[] a = collection.toArray();
        if ((this.size = a.length) != 0){
            if(collection.getClass() == com.dz2.util.ArraysList.class){
                this.arrayData = a;
            }
            else {
                arrayData = Arrays.copyOf(a, this.size, Object[].class);
            }
        }
        else {
            arrayData = DEFAULT_ARRAY;
        }
    }

    private Object[] grow(int min_V){
        int old_V = this.arrayData.length;
        if(old_V > 0 || this.arrayData != DEFAULT_ARRAY){
            int new_V = old_V + (old_V >> 1);
            return this.arrayData = Arrays.copyOf(this.arrayData, new_V);
        }
        else {
            return arrayData = new Object[Math.max(DEFAULT_V, min_V)];
        }
    }

    private Object[] grow(){
        return grow(this.size + 1);
    }

    private void add(E e, Object[] arrayData, int size){
        if(size == arrayData.length)
            arrayData = grow();
        arrayData[size] = e;
        this.size = size + 1;
    }

    public boolean add(E e){
        add(e, this.arrayData, size);
        return true;
    }

    public int size() {
        return size;
    }


    public boolean remove(Object o) {
        int i = 0;
        found: {
            if (o == null){
                for(; i < this.size; i++)
                    if(this.arrayData[i] == null)
                        break found;
            }
            else {
                for (; i<this.size;i++){
                    if (o.equals(this.arrayData[i]))
                        break found;
                }
            }
            return false;
        }
        remove(i);
        return true;
    }

    public boolean addAll(Collection c) {
        return false;
    }
    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) this.arrayData[index];
    }
    @SuppressWarnings("unchecked")
    public E getLast(){
        return (E) this.arrayData[size-1];
    }

    public E remove(int index) {
        E removeValue = (E) this.arrayData[index];
        this.arrayData[index] = null;
        size-=1;
        return removeValue;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
    @SuppressWarnings("unchecked")
    public void sort(Comparator<? super E> c){
        MyArrays.mergeSort((E[])arrayData, 0, size-1, c);
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void clear() {
        this.arrayData = DEFAULT_ARRAY;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }


    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return List.of();
    }

    @SuppressWarnings("unchecked")
    public boolean isSorted(){
        int count = 0;
        for(int i = 0; i < size-1; i++){
            if(((Comparable) arrayData[i]).compareTo(arrayData[i+1]) <= 0){
                count++;
            }
        }

        return count == size - 1;
    }
    @SuppressWarnings("unchecked")
    public boolean isSorted(Comparator<E> c){
        int count = 0;
        for(int i = 0; i < size-1; i++){
            if(c.compare((E)arrayData[i], (E)arrayData[i+1]) <= 0){
                count++;
            }
        }

        return count == size - 1;
    }
}
