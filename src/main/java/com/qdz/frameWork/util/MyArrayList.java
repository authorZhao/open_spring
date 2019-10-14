package com.qdz.frameWork.util;

import java.io.Serializable;
import java.util.*;

public class MyArrayList<E> implements List<E>, RandomAccess, Cloneable, Serializable {


    private static final long serialVersionUID = 8683452581122892189L;

    /**
     * 默认大小，抄袭ArrayList
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 空数组
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};

    /**
     * 不包含空的数组
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    /**
     * 数组元素
     */
    transient Object[] elementData; // non-private to simplify nested class access

    /**
     * 数组大小
     */
    private int size;

    /**
     * 无参构造
     */
    public MyArrayList(){
        this(DEFAULT_CAPACITY);
    }

    /**
     * 有参构造
     * @param initialCapacity 默认10
     */
    public MyArrayList(int initialCapacity) {
        if(initialCapacity<0) {
            try {
                throw new Exception();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        this.elementData=new Object[DEFAULT_CAPACITY];//
    }




    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
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
        Object[] objects =  new Object[size];
        for (int i = 0; i < objects.length; i++) {
            objects[i] = elementData[i];
        }
        return objects;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {

        //1.数组是否装满
        if(size>=elementData.length){
            Object[] objects = new Object[size * 2];
            System.arraycopy(elementData,0,objects,0,size);
            elementData = objects;
            size = size*2;
        }else{
            elementData[size]=e;
            size = size+1;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
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

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        ArrayUtils.checkIndex(index,size);
        return (E)elementData[index];
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    /**
     * 在指定位置添加元素，后面的向后移动
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        ArrayUtils.checkIndex(index,size);
        Object[] objects = new Object[size];
        System.arraycopy(elementData,0,objects,0,index+1);

        for (int i = index+1; i < objects.length; i++) {
            objects[i-1] = elementData[i];
        }
        elementData = objects;
    }

    /**
     * 删除指定位置元素，将后面的数组往前移动
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        ArrayUtils.checkIndex(index,size);
        E e = (E)elementData[index];
        Object[] objects = new Object[size];
        System.arraycopy(elementData,0,objects,0,index+1);
        for (int i = index+1; i < objects.length; i++) {
            objects[i-1] = elementData[i];
        }
        elementData = objects;
        return e;
    }

    @Override
    public int indexOf(Object o) {
        if(o==null)return -1;
        for (int i = 0; i <elementData.length ; i++) {
            if(o.equals(elementData[i]))return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if(o==null)return -1;
        for (int i = elementData.length-1; i <elementData.length ; i++) {
            if(o.equals(elementData[i]))return i;
        }
        return -1;
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
        return null;
    }





}
