package Lab_5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    Stack<Integer> integerStack;
    Stack<String> stringStack;
    @BeforeEach
    void setUp() {
        integerStack = new Stack<Integer>();
        stringStack = new Stack<String>();
    }

    @Test
    void push() {
        integerStack.push(2);
        integerStack.push(3);
        integerStack.push(4);
        integerStack.push(5);
        assertEquals(5,integerStack.pop());
        assertEquals(4,integerStack.pop());

        stringStack.push("a");
        stringStack.push("b");
        stringStack.push("c");
        assertEquals("c",stringStack.pop());
    }

    @Test
    void pop() {
        assertThrowsExactly(NoSuchElementException.class,()->integerStack.pop());
    }
}