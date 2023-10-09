import java.util.Scanner;

public class ReverseWords {
    public static void main(String args[])
    {
                Scanner sc = new Scanner(System.in);
                String str=sc.nextLine();
                System.out.println(reverseWords(str));
    }
    public static String reverseWords(String s) {
        String[] splitted=s.split("\\s+");// \\s+matches  one or more white spaces charchters,effectively separating the words
        StringBuilder sb=new StringBuilder("");

        for(int i=splitted.length-1;i>=0;i--)
        {
            String temp=splitted[i];
            sb.append(temp);
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}