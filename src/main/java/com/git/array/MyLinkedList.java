package com.git.array;


import java.util.*;

/**
 * @author authorZhao
 * @date 2019/12/16
 */
public class MyLinkedList<E> extends AbstractSequentialList<E>
        implements List<E>, Deque<E>, Cloneable, java.io.Serializable{

    transient int size = 0;
    transient Node<E> first;
    transient Node<E> last;

    /**
     * 将该元素放在第一个位置
     * @param e
     */
    private void linkFirst(E e) {
        final Node<E> f = first;
        // 前驱为空，值为e，后继为f
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;// first指向newNode
        // 此时的f有可能为null
        if (f == null)// 若f为空，则表明列表中还没有元素
            last = newNode;// last也应该指向newNode
        else
            f.prev = newNode;// 否则，前first的前驱指向newNode
        size++;
        modCount++;
    }


    /**
     * Links e as last element.
     */
    private void linkLast(E e) {
        final Node<E> f = last;

        //前驱为之前的last
        final Node<E> newNode = new Node<>(f, e, null);

        last = newNode;// first指向newNode
        // 此时的f有可能为null

        if (f == null)// 若f为空，则表明列表中还没有元素
            first = newNode;// last也应该指向newNode
        else
            f.next = newNode;// 否则，前first的前驱指向newNode
        size++;
        modCount++;
    }

    private E unlinkFirst(Node<E> f) {
        final E element = first.item;

        Node next = f.next;
        first = next;

        //帮助gc回收
        f.item=null;
        f.next=null;
        if(next==null){
            last=null;
        }else{
            next.prev=null;
        }

        size--;
        modCount++;
        return element;
    }

    private E unlinkLast(Node<E> l) {
        E e = l.item;
        Node<E> pre = l.prev;

        last = pre;
        l.prev=null;
        l.item=null;

        if(pre==null){
            first=null;
        }else{
            pre.next=null;
        }
        size--;
        modCount++;
        return null;
    }


    /**
     *
     * @param e 新增的元素
     * @param succ 之前的元素
     */
    private void linkBefore(E e, Node<E> succ) {
        Node<E> prev = succ.prev;
        Node<E> newNode = new Node<>(prev,e,succ);
        succ.prev=newNode;
        if(prev==null){
            first=newNode;
        }else{
            prev.next=newNode;
        }
        size++;
        modCount++;
    }

    private E unlink(Node<E> e) {
        E item = e.item;
        Node<E> prev = e.prev;
        Node<E> next = e.next;
        if(prev==null){
            first=next;
        }else{
            prev.next=next;
            e.prev=null;
        }

        if(next==null){
            last=prev;
        }else{
            next.prev=prev;
            e.next=null;
        }
        e.item=null;
        size--;modCount++;
        return item;
    }

    private Node<E> node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public void add(int index, E element) {
        //因为是添加，最后一个下标可以是size
        ArrayUtils.checkIndex(index,size+1);

        if(index==size){
            linkLast(element);
        }else{
            linkBefore(element,node(index));
        }
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }



    @Override
    public int size() {
        return size;
    }

    @Override
    public void addFirst(E e) {
        linkFirst(e);
    }

    @Override
    public void addLast(E e) {
        linkLast(e);
    }


    @Override
    public E removeFirst() {
        Node<E> f = first;
        if(f==null) throw new NoSuchElementException();
        return unlinkFirst(f);
    }

    @Override
    public E removeLast() {
        Node<E> l = first;
        if(l==null) throw new NoSuchElementException();
        return unlinkLast(l);
    }

    @Override
    public E get(int index) {
        ArrayUtils.checkIndex(index,size);
        Node<E> x = node(index);
        return (E)x.item;
    }

    @Override
    public E getFirst() {
        if(first==null)throw new NoSuchElementException();
        return first.item;
    }

    @Override
    public E getLast() {
        if(last==null)throw new NoSuchElementException();
        return last.item;
    }

    @Override
    public E remove() {
        Node<E> node = last;
        if(node==null)throw new NoSuchElementException();
        unlinkLast(last);
        return node.item;
    }

    @Override
    public E remove(int index) {
        ArrayUtils.checkIndex(index,size);
        Node<E> node = node(index);
        unlink(node);
        return node.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override
    public E pollFirst() {
        return null;
    }

    @Override
    public E pollLast() {
        return null;
    }

    @Override
    public boolean offerFirst(E e) {
        return false;
    }

    @Override
    public boolean offerLast(E e) {
        return false;
    }


    @Override
    public E peekFirst() {
        return null;
    }

    @Override
    public E peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return super.remove(o);
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public void push(E e) {

    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return new Itr();
    }

    private class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }


    private class Itr implements Iterator<E>{

        int cursor = 0;       // 返回下一个元素的下标
        int lastRet = -1; // 最后一次操作元素的下标

        // prevent creating a synthetic constructor
        private Itr() {}

        @Override
        public boolean hasNext() {
            return cursor!=size;
        }

        @Override
        public E next() {
            ArrayUtils.checkIndex(cursor,size+1);
            lastRet = cursor;
            cursor++;
            Node<E> node = node(lastRet);
            return node.item;
        }

        @Override
        public void remove() {
            ArrayUtils.checkIndex(cursor,size+1);
            if (lastRet < 0)
                throw new IllegalStateException();
            unlink(node(lastRet));
            cursor=lastRet;
            lastRet=-1;

        }
    }
}
