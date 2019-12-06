import org.junit.Assert;
import org.junit.Test;
import java.util.*;

public class TestStack {
    @Test
    public void testStack1() {
        MyStack<Integer> test1 = new MyStack<>();
        int fst = 2, snd = 7;
        int count = 2;
        test1.push(fst);
        test1.push(snd);
        Iterator<Integer> iter = test1.stack.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
        Assert.assertEquals(count, test1.count());
        count--;
        Assert.assertEquals(snd, (int)test1.pop());
        Assert.assertEquals(count, test1.count());
        count--;
        Assert.assertEquals(fst, (int)test1.pop());
        Assert.assertEquals(count, test1.count());
    }

    @Test
    public void testStack2() {
        MyStack<String> test2 = new MyStack<>();
        String fst = "first", snd = "second";
        String thd = "third", fth = "fourth";
        test2.push(fst);
        test2.push(snd);
        test2.push(thd);
        test2.push(fth);
        Iterator<String> iter = test2.stack.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
        Assert.assertEquals(fth, test2.pop());
        Assert.assertEquals(thd, test2.pop());
        Assert.assertEquals(snd, test2.pop());
        Assert.assertEquals(fst, test2.pop());
    }
}