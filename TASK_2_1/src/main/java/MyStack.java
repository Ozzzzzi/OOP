import java.util.*;

public class MyStack<T> {

    public List<T> stack;

    /**
     * Sole constructor. Initializes the stack.
     */
    public MyStack() {
        stack = new ArrayList<>();
    }

     /** Puts a new <code>element</code> at the top of the stack.
     *
     * @param element    the element to be added
     */
    public void push(T element) {
        stack.add(element);
    }

    /** Gets an element from the top of the stack.
     *
     * @return  the received element
     * @throws  IndexOutOfBoundsException  If stack is empty and it's
     *                                     impossible to get an element
     */
    public T pop() throws IndexOutOfBoundsException {
        if (stack.isEmpty()) {
            throw new IndexOutOfBoundsException("Stack is empty");
        } else {
            int el_num = stack.size();
            return stack.remove(el_num - 1);
        }
    }

    /** Gets the current stack size.
     *
     * @return  the number of elements on the stack
     */
    public int count() {
        return stack.size();
    }
}
