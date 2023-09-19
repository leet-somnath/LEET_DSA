/*
 
Problem Statement

Valera the Horse is going to the party with friends. He has been following the fashion trends for a while, and he knows
that it is very popular to wear all horseshoes of different colors. Valera has got four horseshoes left from the last year,
but maybe some of them have the same color. In this case, he needs to go to the store and buy a few more horseshoes,
 not to lose face in front of his stylish comrades.

Fortunately, the store sells horseshoes of all colors under the sun, 
and Valera has enough money to buy any four of them. However, 
in order to save money, he would like to spend as little as possible. 
Your task is to help Valera determine the minimum number of horseshoes he needs to buy to wear four horseshoes of different colors to the party.

Input

The first line contains four space-separated integers s1, s2, s3, s4 (1 ≤ s1, s2, s3, s4 ≤ 10^9) — 
the colors of horseshoes Valera has. Consider all possible colors indexed with integers.

Output

Print a single integer — the minimum number of horseshoes Valera needs to buy.

Examples

Input: 1 7 3 3

Output: 1
 */

 //solution:-
import java.util.*;
public class A_Is_your_horseshoe_on_the_other_hoof {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
        HashSet<Integer> x=new HashSet<>();
        int n=0;
        while(n<4){
            if(sc.hasNextInt()){
                int c=sc.nextInt();
                x.add(c);
            }
            else
            break;
        }
        System.out.println(4-x.size());
        sc.close();
    }
}