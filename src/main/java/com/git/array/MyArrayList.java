package com.git.array;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;

/**
 *RandomAccess 支持随机访问，毕竟ArrayList是封装数组，该接口表明遍历ArrayList采用for循环比迭代器更快
 *Cloneable 克隆接口
 *Serializable 序列化接口
 *
 */
public class MyArrayList<E> implements List<E>, RandomAccess, Cloneable, Serializable {

    private static final long serialVersionUID = 8683452581122892189L;

    protected transient int modCount = 0;

    /**
     * 默认大小，抄袭ArrayList
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 数组元素
     */
    transient Object[] elementData; // non-private to simplify nested class access

    /**
     * 数组大小
     */
    private int size;

    /**
     * 无参构造，默认大小为10，还准备了
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
        return indexOf(o)>0?true:false;
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
        for (int i = 0; i < a.length; i++) {
            a[i] = (T)elementData[i];
        }
        return a;
    }


    @Override
    public boolean remove(Object o) {
        int i = indexOf(o);
        if(i>0){
            remove(i);
            return true;
        }
        return false;
    }


    @Override
    public void clear() {
        MyArrayList<E> myArrayList = new MyArrayList<>(size);
        size=0;
    }


    @Override
    public boolean add(E e) {
        //1.数组是否装满
        if(size>=elementData.length){
            //扩容，采用arraycopy方法
            Object[] objects = new Object[elementData.length * 2];
            System.arraycopy(elementData,0,objects,0,size);
            elementData = objects;
        }
        elementData[size]=e;
        size = size+1;
        return true;
    }

    /**
     * 在指定位置添加元素，后面的向后移动
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        ArrayUtils.checkIndex(index,size);

        Object[] objects;
        //判断是否需要扩容
        if(size>=elementData.length){
            objects = new Object[elementData.length * 2];
        }else{
            objects = new Object[elementData.length];
        }
        size++;
        System.arraycopy(elementData,0,objects,0,index);
        objects[index] = element;

        for (int i = index; i < size; i++) {
            objects[i+1] = elementData[i];
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
        int nextLength = elementData.length;
        Object[] objects = new Object[nextLength];
        System.arraycopy(elementData,0,objects,0,elementData.length);
        for (int i = index+1; i < nextLength; i++) {
            objects[i-1] = elementData[i];
        }
        elementData = objects;
        size--;
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
    @Override
    public E get(int index) {
        ArrayUtils.checkIndex(index,size);
        return (E)elementData[index];
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }


    private class Itr implements Iterator<E> {
        int cursor = 0;       // 返回下一个元素的下标
        int lastRet = -1; // 最后一次操作元素的下标

        // prevent creating a synthetic constructor
        private Itr() {}

        public boolean hasNext() {
            return cursor != size;
        }

        @SuppressWarnings("unchecked")
        public E next() {
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Object[] elementData = MyArrayList.this.elementData;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;
            return (E) elementData[lastRet = i];
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            try {
                MyArrayList.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

       /* @Override
        public void forEachRemaining(Consumer<? super E> action) {
            Objects.requireNonNull(action);
            final int size = MyArrayList.this.size;
            int i = cursor;
            if (i < size) {
                final Object[] es = elementData;
                if (i >= es.length)
                    throw new ConcurrentModificationException();
                for (; i < size && modCount == expectedModCount; i++)
                    action.accept(elementAt(es, i));
                // update once at end to reduce heap write traffic
                cursor = i;
                lastRet = i - 1;
                checkForComodification();
            }
        }*/

    }



}


