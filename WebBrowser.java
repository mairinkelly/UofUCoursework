package assign06;

import java.net.URL;
import java.util.LinkedList;
import java.util.NoSuchElementException;
/**
 * This class simulates a web browser, with the ability
 * to move forward, backward, and visit various URLs.
 *
 * @author Keegan Richardson and Mairin Kelly
 * @version February 25, 2023
 *
 */
public class WebBrowser {
    private Stack<URL> forward;
    private Stack<URL> back;
    private URL current;

    /**
     * This constructor creates a new web browser with
     * no previously-visited webpages and no webpages
     * to visit next.
     */
    public WebBrowser()
    {
        forward = new LinkedListStack<URL>();
        back = new LinkedListStack<URL>();
        current = null;
    }

    /**
     * This constructor creates a new web browser with a
     * history of visited webpages, given as a list of URLs.
     * @param history
     */
    public WebBrowser(SinglyLinkedList<URL> history)
    {
        forward = new LinkedListStack<URL>();
        back = new LinkedListStack<URL>();
        current = null;
        if (history.size() != 0) {
            for (int i = history().size(); i > 0; i--) {
                back.push((URL) history.get(i));
            }
        }
    }

    /**
     * This method returns the current webpage.
     * @return
     */
    public URL getCurrent()
    {
        return current;
    }

    /**
     * This method simulates visiting a webpage,
     * given as a URL parameter.
     * @param webpage
     */
    public void visit(URL webpage)
    {
        if (current != null)
          back.push(current);
        current = webpage;
        forward.clear();
    }

    /**
     * This method simulates using the back button,
     * and returns a URL.
     * @return URL
     * @throws NoSuchElementException
     */
    public URL back() throws NoSuchElementException
    {
        if (back.isEmpty())
            throw new NoSuchElementException();
        URL element = back.pop(); // get rid of top of back
        forward.push(current); // add the old current to forward
        current = element;
        return current;
    }

    /**
     * This method simulates using the forward button,
     * and returns a URL.
     * @return URL
     * @throws NoSuchElementException
     */
    public URL forward() throws NoSuchElementException
    {
        if (forward.isEmpty())
            throw new NoSuchElementException();
        URL element = forward.pop(); // get rid of top of forward
        back.push(current); // add the old current to back
        current = element;
        return current;
    }

    /**
     * This method generates a list of the history of
     * webpages visited.
     * @return
     */
    public SinglyLinkedList<URL> history()
    {
        SinglyLinkedList<URL> list = new SinglyLinkedList<URL>();
        Stack<URL> temp = new LinkedListStack<URL>();
        int size = back.size();
       for (int i = 0; i < size; i++)
       {
           temp.push(back.pop());
       }
       for (int i = 0; i < size; i++)
       {
           back.push(temp.peek()); // push what you peek back into back
           list.insert(i,temp.pop()); // push what you pop into list
       }
        // list is now in wrong order, so copy backwards into new list
        SinglyLinkedList<URL> list2 = new SinglyLinkedList<URL>();

        int size2 = list.size();
        for (int i = 0; i < size2; i++)
        {
            list2.insert(i,list.get(list.size()-i-1));
        }

        list2.insertFirst(current);
        return list2;
    }
}
