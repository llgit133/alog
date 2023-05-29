package org.example.stack_queue;

import java.util.Stack;

public class Offer_3_30 {

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        minStack.min();
        minStack.pop();
        minStack.top();
        minStack.min();
    }
}
class MinStack {

    Stack<Integer> stack;
    Stack<Integer> temp;

    public MinStack() {
        this.stack = new Stack<>();
        this.temp = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        int min = temp.isEmpty() ? x : Math.min(temp.peek(), x);
        temp.push(min);
    }

    public void pop() {
        stack.pop();
        temp.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return temp.peek();
    }
}