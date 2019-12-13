import org.junit.Assert;
import org.junit.Test;
import java.util.*;

public class TestStack {
    @Test
    public void testStack1() {
        MyStack<Integer> test1 = new MyStack<>(Integer.class, 5);
        test1.push(1);
        test1.push(2);
        test1.push(3);
        test1.push(4);
        test1.push(5);
        Iterator<Integer> iter = test1.iterator();
        int cnt = 5;
        while(iter.hasNext()) {
            System.out.println(test1.count());
            int el = iter.next();
            System.out.println(el);
            Assert.assertEquals(cnt, el);
            cnt--;
        }
    }

    @Test
    public void testStack2() {
        MyStack<String> test2 = new MyStack<>(String.class, 10);
        test2.push("fst");
        test2.push("snd");
        test2.push("thd");
        test2.push("fth");
        Assert.assertEquals("fth", test2.pop());
        Assert.assertEquals("thd", test2.pop());
        Assert.assertEquals("snd", test2.pop());
        Assert.assertEquals("fst", test2.pop());
    }
}