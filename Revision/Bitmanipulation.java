import java.util.Scanner;

public class Bitmanipulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 10, b = 9;
        //1.arthementic addition without operator
        int res = addtionwithoutarthemeticoperatior(a, b);
        System.out.println(res);
        // 2 binary representaion
        int n = sc.nextInt();
        binaryrepresentaion(n);
        System.out.println();
        // 3getting ith bit
        System.out.println("index?");
        int i = sc.nextInt();
        System.out.println(getith(n, i));
        // 4 count set bits
        System.out.println("the total set bits" + count_set_bits(n));
        // 5 set ith bit
        System.out.println("enter the number and index to be set");
        int num = sc.nextInt();
        int indx = sc.nextInt();
        setithbit(num, indx);

        // 6 clearith bit
        System.out.println("index to clear?");
        int ind = sc.nextInt();
        clearithbit(num, ind);

        // 7 update ith bit
        System.out.println("value to be updated and which index??");
        int valtobeupdated = sc.nextInt();
        int idx = sc.nextInt();
        updateithbit(num, valtobeupdated, idx);
        // 8 clear bits from i to j
        System.out.println("from what to what position u want to clear");
        int ipos = sc.nextInt();
        int jpos = sc.nextInt();
        clearbitsfromiTojposition(num, ipos, jpos);

        // update bits from i to j
        System.out.println("i,j,value");
        int updfrom = sc.nextInt(), updto = sc.nextInt();
        int value = sc.nextInt();
        updatebitsfromitotoposition(num, updfrom, updto, value);

        // Check N is power of 2 or not
        System.out.println("number to check 2 powers?");
        int powcheck = sc.nextInt();
        System.out.println(n_is_power_of_two(powcheck));

        // get msb and least bit
        System.out.println("enter a numbr for msb and lsb");
        int y = sc.nextInt();
        getmsbandlsb(y);

        //

        sc.close();
    }

    public static int addtionwithoutarthemeticoperatior(int a, int b) {
        return ((a | b) + (a & b));
    }

    public static void binaryrepresentaion(int n) {
        int maxSetBit = (int) (Math.log(n) / Math.log(2));
        for (int i = maxSetBit; i >= 0; i--) {
            int k = 1 << i;
            if ((n & k) != 0)
                System.out.print("1");
            else
                System.out.print("0");
        }
    }

    public static void clearbitsfromiTojposition(int n, int i, int j) {
        int a = -1 << j + 1;
        int b = 1 << i - 1;
        n = (n & (a | b));
        System.out.println(n);
    }

    public static int getith(int n, int i) {
        if (((n) & (1 << i)) > 0)
            return 1;
        else
            return 0;
    }

    public static void updateithbit(int n, int value, int i) {
        clearithbit(n, i);
        n = (n | (value << i));
        System.out.println(n);
    }

    public static void getmsbandlsb(int n) {

        System.out.println("lsb" + " " + (n & 1));
        int msb = (int) (Math.log(n) / Math.log(2));

        System.out.println(msb);

    }

    
    public static int count_set_bits(int n) {
        int cont = 0;
        while (n > 0) {
            n = (n & (n - 1));
            cont++;
        }
        return cont;
        /*
         * for(int i=0;i<Math.log(n);i++)
         * {
         * if((n&(1<<i))>0)
         * cont++;
         * }
         * return cont;
         */
    }

    public static void setithbit(int n, int i) {
        n = (n | (1 << i));
        System.out.println(n);
    }

    public static void clearithbit(int n, int i) {
        n = (n & (~(1 << i)));
        System.out.println(n);
    }

    public static void updatebitsfromitotoposition(int n, int i, int j, int value) {
        clearbitsfromiTojposition(n, i, j);
        n = (n & (value << i));
        System.out.println("after" + n);
    }

    public static boolean n_is_power_of_two(int n) {
        return (n & (n - 1)) > 0 ? false : true;
    }

}