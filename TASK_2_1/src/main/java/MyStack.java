import java.lang.reflect.Array;
import java.util.*;

public class MyStack<T> implements Iterable<T> {

    private T[] stack;
    private int count1;
    private int size;

    /**
     * Sole constructor. Initializes the stack.
     */

    public MyStack(Class<T> classs, int cap) {
            stack = (T[]) Array.newInstance(classs, cap);
            count1 = 0;
            size = cap;
    }

     /** Puts a new <code>element</code> at the top of the stack.
     *
     * @param element    the element to be added
     */
     public void push(T element) {
         if (count1 == size) {
             throw new IndexOutOfBoundsException("Stack limit was reached");
         } else {
             stack[count1] = element;
             count1++;
         }
     }

    /** Gets an element from the top of the stack.
     *
     * @return  the received element
     * @throws  IndexOutOfBoundsException  If stack is empty and it's
     *                                     impossible to get an element
     */
    public T pop() {
        if (count1 == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        } else {
            return stack[--count1];
        }
    }

    /** Gets the current stack size.
     *
     * @return  the number of elements on the stack
     */
    public int count() {
        return count1;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {

            public boolean hasNext() {
                if (count1 > 0) {
                    return true;
                } else {
                    return false;
                }
            }

            public T next() {
                if (count1 == 0) {
                    throw new NoSuchElementException("No next element");
                } else {
                    return pop();
                }
            }
        };
    }
}
