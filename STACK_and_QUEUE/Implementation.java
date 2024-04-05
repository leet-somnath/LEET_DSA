import java.util.*;
import java.io.*;

class stacky {
    ArrayList<Integer> arr = new ArrayList<>();
    int top;

    stacky() {
        top = -1;
    }

    public void push(int x) {
        arr.add(x);
        top = top + 1;
    }

    public int pop() {
        int lastvalue = arr.get(top);
        arr.remove(top);
        --top;
        return lastvalue;
    }

    public int peek() {
        if (top == -1)
            return -1;
        else
            return (arr.get(top));
    }
}

public class Implementation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        stacky st = new stacky();
        st.push(12);
        st.push(23);
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.peek());
        sc.close();
    }
}