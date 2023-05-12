package assign06;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * This class contains methods that alter and return elements of a singly linked list, as
 * well as an iterator.
 *
 * @author Keegan Richardson and Mairin Kelly
 * @version February 25, 2023
 *
 */
public class SinglyLinkedList<E> implements List {

    /**
     * Nest class for creating Nodes
     * @param <E>
     */
    public static class SLLNode<E>{
        SLLNode next;
        E data;
        public SLLNode(E data1, SLLNode<E> node){
            this.data = data1;
            this.next = node;
        }

    }

    private int size;
    private E[] arr;
    private SLLNode<E> head;
    private SLLNode<E> tail;


    /**
     * This is the constructor that creates a one element array.
     */
    public void SingleLinkedList()
    {
        this.arr = (E[]) new Object[1];
    }

    /**
     * Inserts the object into the first index of the list
     *
     * @param element - the element to add
     */
    @Override
    public void insertFirst(Object element) {
        // replace current head with new element head node
        head = new SLLNode(element,head);
        // set tail
        if (size == 0)
            tail = head;
        // update size
        size++;
    }

    /**
     * Inserts the given element into the specified index of the list
     *
     * @param index - the specified position
     * @param element - the element to add
     * @throws IndexOutOfBoundsException
     */
    @Override
    public void insert(int index, Object element) throws IndexOutOfBoundsException {

        if (index > size  || index < 0)
        {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0)
        {
            insertFirst(element); // call insertFirst
        }

        else {
            var pointer = head;
            for(int i = 0; i<index-1; i++){
                pointer = pointer.next; // loop through until you reach the desired index
            }
            pointer.next = new SLLNode(element,pointer.next);

            // set tail
            var pointer2 = head;
            for (int i = 0; i < size; i++)
                pointer2 = pointer2.next;
            tail = pointer2;

            size++;
        }


    }

    /**
     * Returns the first element of the list
     *
     * @return first -
     * @throws NoSuchElementException
     */
    @Override
    public E getFirst() throws NoSuchElementException {
        if (size == 0)
            throw new NoSuchElementException();
        return head.data;
    }

    /**
     * Returns the element at the specified index
     *
     * @param index - the specified position
     * @return
     * @throws IndexOutOfBoundsException
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index > size - 1 || index < 0)
            throw new IndexOutOfBoundsException();
        var pointer = head;
        for(int i = 0; i<index; i++){
            pointer = pointer.next;
        }
        return pointer.data;
    }

    /**
     * Deletes the first element in the list
     *
     * @return
     * @throws NoSuchElementException
     */
    @Override
    public E deleteFirst() throws NoSuchElementException {
        if(size == 0)
            throw new NoSuchElementException();
        E temp = head.data;
        head = head.next;
        size--;
        return temp;
    }

    /**
     * Deletes the element in the list at the given index
     *
     * @param index - the specified position
     * @return
     * @throws IndexOutOfBoundsException
     */
    @Override
    public E delete(int index) throws IndexOutOfBoundsException {
        if(index > size-1 || index < 0)
            throw new IndexOutOfBoundsException();

        var pointer = head;
        E temp;

        if (index == 0) {
            temp = head.data;
            head = head.next;
        }

        else if (pointer.next == null)
        {
            temp = pointer.data;
            head = pointer.next;
        }
        else
        {
            for(int i = 0; i<index-1; i++){
                pointer = pointer.next;
            }
            temp = (E) pointer.next.data;
            pointer.next = pointer.next.next;
        }
        size--;
        return temp;
    }

    /**
     * Returns the list index of the given element
     *
     * @param element - the element to search for
     * @return
     */
    @Override
    public int indexOf(Object element)
    {
        if (size == 0)
            return -1;
        var pointer = head;
        int i = 0;
        boolean found = false;
        while (found == false)
        {
            if (element.equals(pointer.data))
            {
                found = true;
                break;
            }
            if (pointer.next == null)
            {
                i = -1;
                break;
            }
            pointer = pointer.next;
            i++;
        }
        return i;
    }

    /**
     * Returns the size of the list
     * the number of elements in the list
     *
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Determines if the list contains elements or not (empty)
     *
     * @return true - if the list has no elements and is empty
     * @return false - if the list has elements and is not empty
     */
    @Override
    public boolean isEmpty() {
        if(head == null)
            return true;
        return false;
    }

    /**
     * Deletes all elements of the list so that it is a clear/empty list
     *
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Turns the list into an array
     *
     * @return
     */
    @Override
    public E[] toArray() {
        var pointer = head;
        Object[] arr = new Object[size];
        for (int i = 0; i < size ; i++)
        {
            arr[i] = pointer.data;
            pointer = pointer.next;
        }
        return (E[]) arr;
    }


    /**
     * Iterator
     *
     * @return
     */
    @Override
    public Iterator iterator() {
        return new SLLIterator();
    }

    /**
     * Nested class that represents an Iterator that will be used within the main SingleLinkedList class
     *
     */
    public class SLLIterator implements Iterator<E>{
        private SLLNode index;
        private boolean hasNextBeenCalled;
        private int size;

        /**
         * constructor for Iterator class
         */
        public  SLLIterator(){
            index = head;
            hasNextBeenCalled = false;
            size = size();
        }

        /**
         * Checks to see if there is another value within the list
         * @return true - if there is another element next
         * @return flase - if there is no element next, size value reached
         */
        @Override
        public boolean hasNext() {
            if (index == null)
                return false;
            else
                return true;
        }

        /**
         * Moves the iterator to the next item
         * within the list
         * @return E
         */
        @Override
        public E next() {
            if (hasNext())
            {
                E data = (E) index.data;
                index = index.next;
                hasNextBeenCalled = true;
                return data;
            }
            else
                throw new NoSuchElementException();
        }

        /**
         * Removes the current element in the list
         */
        @Override
        public void remove() {
            if (hasNextBeenCalled == false)
                throw new IllegalStateException();
            hasNextBeenCalled = false;
            index = index.next;
            size--;
        }
    }
}
