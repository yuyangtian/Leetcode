import java.util.LinkedList;

public class MyQueue {
    private LinkedList<Integer> stack;
    private LinkedList<Integer> cache;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new LinkedList<Integer>();
        cache = new LinkedList<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int result;
        while(!stack.isEmpty()){
            cache.add(stack.removeLast());
        }
        result = cache.removeLast();
        while(!cache.isEmpty()){
            stack.add(cache.removeLast());
        }
        System.out.println(result);
        return result;
    }

    /** Get the front element. */
    public int peek() {
        int result;
        while(!stack.isEmpty()){
            cache.add(stack.removeLast());
        }
        result = cache.getLast();
        while(!cache.isEmpty()){
            stack.add(cache.removeLast());
        }
        System.out.println(result);
        return result;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        System.out.println(stack.isEmpty());
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.peek();  // 返回 1
        queue.pop();   // 返回 1
        queue.empty(); // 返回 false

    }
}
