import java.util.ArrayList;

//num 155
public class MinStack {
    /** initialize your data structure here. */
    ArrayList<Integer> arr;
    ArrayList<Integer> min;
    public MinStack() {
        arr = new ArrayList<>();
        min = new ArrayList<>();
        min.add(Integer.MAX_VALUE);
    }

    public void push(int x) {
        arr.add(x);
        min.add(Math.min(x,min.get(min.size()-1)));
    }

    public void pop() {
        arr.remove(arr.size()-1);
        min.remove(min.size()-1);
    }

    public int top() {
        return arr.get(arr.size()-1);
    }

    public int getMin() {
        System.out.println(min.get(min.size()-1));
        return min.get(min.size()-1);
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }
}

