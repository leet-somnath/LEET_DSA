class Solution {
    //Create Value Stack
    Stack<Integer> valueStack = new Stack<>();
    //Create Min Stack
    Stack<Integer> minStack = new Stack<>();
   
    public void push(int x) {
        if(valueStack.size() == 0) {
            valueStack.push(x);
            minStack.push(x);
            return;
        } else {
            valueStack.push(x);
            if(x <= minStack.peek()) {
                minStack.push(x);
            }
        }
    }

    public void pop() {
        if(valueStack.size() != 0) {
            int temp = valueStack.pop();
            if(temp == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    public int top() {
        if(valueStack.size() == 0) {
            return -1;
        } else {
            return valueStack.peek();
        }
    }

    public int getMin() {
        if(minStack.size() == 0) {
            return -1;
        } else {
            return minStack.peek();
        }
    }
}
