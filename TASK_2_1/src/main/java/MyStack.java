import java.util.*;

public class MyStack<T> {

    public List<T> stack;

    MyStack() {
        stack = new ArrayList<>();
    }

    public void push(T element) {
        stack.add(element);
    }

    public T pop() throws IndexOutOfBoundsException {
        if (stack.isEmpty()) {
            throw new IndexOutOfBoundsException("Stack is empty");
        } else {
            int el_num = stack.size();
            return stack.remove(el_num - 1);
        }
    }

    public int count() {
        return stack.size();
    }
}
