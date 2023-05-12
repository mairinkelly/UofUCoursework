package assign06;

import java.util.NoSuchElementException;
/**
 * This class creates a linked list stack with ways to access,
 * add to, and remove the top element.
 *
 * @author Keegan Richardson and Mairin Kelly
 * @version February 25, 2023
 *
 */
public class LinkedListStack<E> implements Stack<E>{
    private SinglyLinkedList<E> sll;

    /**
     * This is the constructor that creates a new singly linked list.
     */
    public LinkedListStack()
    {
        sll = new SinglyLinkedList<>();
    }

    /**
     * This method clears all of the values in the stack.
     */
    @Override
    public void clear() {
        sll.clear();
    }

    /**
     * This will return true if the stack is empty,
     * false otherwise.
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        if (sll.isEmpty())
            return true;
        else
            return false;
    }

    /**
     * This method peeks at the top item in the stack and
     * returns it.
     * @return E
     * @throws NoSuchElementException
     */
    @Override
    public E peek() throws NoSuchElementException {
        if (sll.isEmpty())
            throw new NoSuchElementException();
        return (E) sll.get(sll.size() - 1);
    }

    /**
     * This method returns and deletes the top
     * element of the stack.
     * @return E
     * @throws NoSuchElementException
     */
    @Override
    public E pop() throws NoSuchElementException {
        if (sll.isEmpty())
            throw new NoSuchElementException();
        return (E) sll.delete(sll.size() - 1);
    }

    /**
     * This method adds an item to the top of the stack.
     * @param element - the element to be added
     */
    @Override
    public void push(E element)
    {
        sll.insert(sll.size(),element);
    }

    /**
     * This method returns the size of the stack.
     * @return int
     */
    @Override
    public int size() {
        return sll.size();
    }
}
