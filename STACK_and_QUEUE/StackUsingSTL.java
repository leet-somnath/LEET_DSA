import java.util.*;
import java.io.*;

public class StackUsingSTL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> st = new ArrayDeque<>();
        st.push(23);
        st.push(3);
        System.out.println(st.pop());
        st.clear();
        System.out.println(st.size());
        st.push(36);
        System.out.println(st.contains(36));
        System.out.println(st.peek());
        System.out.println(st.isEmpty());
        sc.close();
    }
}