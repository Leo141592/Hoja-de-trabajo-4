package stack;

import stack.ArrayListStack;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayListStackTest {

    @Test
    public void testPushAndSize() {
        ArrayListStack<Integer> stack = new ArrayListStack<>();

        stack.push(10);
        stack.push(20);

        assertEquals(2, stack.size());
    }

    @Test
    public void testPop() {
        ArrayListStack<Integer> stack = new ArrayListStack<>();

        stack.push(5);
        stack.push(15);

        int popped = stack.pop();

        assertEquals(15, popped);
        assertEquals(1, stack.size());
    }

    @Test
    public void testPeek() {
        ArrayListStack<Integer> stack = new ArrayListStack<>();

        stack.push(100);
        stack.push(200);

        assertEquals(200, (int) stack.peek());
        assertEquals(2, stack.size());
    }

    @Test(expected = RuntimeException.class)
    public void testPopOnEmptyThrowsException() {
        ArrayListStack<Integer> stack = new ArrayListStack<>();
        stack.pop();
    }
}