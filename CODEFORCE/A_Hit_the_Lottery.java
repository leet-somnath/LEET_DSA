import java.util.Scanner;
public class A_Hit_the_Lottery {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int count=0;
while(n>0){
    if(n>=100){
        n=n-100;
        count++;
    }
    else if(n>=20){
        n=n-20;
        count++;
    }
    else if(n>=10){
        n=n-10;
        count++;
    }
    else if(n>=5){
        n=n-5;
        count++;
    }
    else{
        n=n-1;
        count++;
    }
}
System.out.println(count);
        
sc.close();
    }
}