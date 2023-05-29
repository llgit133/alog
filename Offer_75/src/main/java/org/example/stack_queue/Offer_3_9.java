package org.example.stack_queue;

import java.util.Stack;

public class Offer_3_9 {

    public static void main(String[] args) {
        CQueue queue = new CQueue();
        queue.appendTail(3);

    }
}


class CQueue {

    Stack<Integer> stack;
    Stack<Integer> temp;
    public CQueue() {
        stack = new Stack<>();
        temp = new Stack<>();
    }
    // 输入栈 ：只需要接收 添加到队列尾部的元素;
    public void appendTail(int value) {
        stack.push(value);
    }
    // 输出栈 ：有且仅有在输出栈为空时，才会将弹出输入栈中元素 && 将其加入到输出栈中;
    public int deleteHead() {
        if(temp.isEmpty()){
            // 输入输出栈，都为空
            if(stack.isEmpty()){return -1;}

            // 输入栈中所有元素，全部压栈到输出栈中;
            while(!stack.isEmpty()){temp.push(stack.pop());}
        }
        // 直接返回输出栈的栈顶元素即可;
        return temp.pop();
    }
}