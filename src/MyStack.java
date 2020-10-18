import java.util.LinkedList;
import java.util.Queue;
//num 225
public class MyStack {
    Queue<Integer> queue;
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        int size = queue.size();
        queue.add(x);
        for(int i=0;i<size;i++)
        {
            queue.add(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int a = queue.poll();
    //    System.out.println(a);
        return a;
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack m = new MyStack();
        m.push(0);
        m.push(1);
        m.push(2);
        m.push(3);
        m.pop();
        m.pop();
    }
}
