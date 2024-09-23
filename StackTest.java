import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    @Test
    public void pushTest() {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(10);
        stack.push(15);
        assertEquals(15,stack.peek());
        stack.pop();
        assertEquals(2, stack.size());
    }

    @Test
    public void popTest() {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(10);
        stack.push(15);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        assertEquals(null, stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    public void peekTest() {
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.peek();
        stack.peek();
        assertEquals("C", stack.peek());
    }

    @Test
    public void push2Test() {
        Stack<Integer> stack = new Stack<>();
        stack.push2(5);
        stack.push2(10);
        stack.push2(15);
        assertEquals(15,stack.peek2());
        stack.pop2();
        assertEquals(2, stack.size());
    }

    @Test
    public void pop2Test() {
        Stack<Integer> stack = new Stack<>();
        stack.push2(5);
        stack.push2(10);
        stack.push2(15);
        stack.pop2();
        stack.pop2();
        stack.pop2();
        stack.pop2();
        assertEquals(null, stack.pop2());
        assertEquals(0, stack.size());
    }

    @Test
    public void peek2Test() {
        Stack<String> stack = new Stack<>();
        stack.push2("A");
        stack.push2("B");
        stack.push2("C");
        stack.peek2();
        stack.peek2();
        assertEquals("C", stack.peek2());
    }

    @Test
    public void balanceTest() {
        assertEquals(true,Stack.balance("(()((())()))"));
        assertEquals(false,Stack.balance("(()((())())))"));
        assertEquals(false,Stack.balance("(()((())())("));
        assertEquals(false,Stack.balance("())("));
        assertEquals(false,Stack.balance("))(("));
        assertEquals(false,Stack.balance("((())"));
        assertEquals(false,Stack.balance("{[(])}"));
        assertEquals(false,Stack.balance("([)]"));
        assertEquals(true,Stack.balance("{[()]}"));
    }

    @Test
    public void averageTest() {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(10);
        stack.push(15);
        assertEquals(10,stack.getAverage());
    }

    @Test
    public void minValueTest() {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(10);
        stack.push(15);
        stack.push(5);
        stack.push(0);
        stack.push(5);
        assertEquals(0,stack.getMin());
    }

    @Test
    public void postfixTets() {
        Stack stack = new Stack();
        String s = "8 2 + 5 * 9 + =";
        assertEquals(59,stack.postfix(s));
        s = "8 2 + 5 * 9 +";
        assertEquals(59,stack.postfix(s));
    }
}