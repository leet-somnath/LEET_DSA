
/*
------------------------=problems on binary search=-----------------------------------------------------
 * upper bound(upper bound is defined as smallest index such that arr[i]>n)
 * lower bound(lower bound is defined as smallest index such that arr[i]>=n)
 * search postion to insert in sorted array(indirect lowerbound)
 * floor of a numberI
 * ceil of a number(lowerbound of a number)
 * find peak element (peak element is greater than its neighbours)
 * search element in bitonic array(incresing and then decreasing)
 * smallest number in roated array containing duplicate elements
 * no of roations of sorted array containing duplicate elements
 * search element in rotated array  containing duplicate elements
 * find the first and last occurance and frequency of the given element
 * find smallest missing element
 * find single element in the array using binary search
 * sqrt,cuberoot,nth root of number
 * search in roated sorted array with duplicates
 * 
 * ----------------------=problems on answers=------------------------------------------------------------
 * koko eating bananas (binary search on answer)
 * find the minimum number of days to make m bouquets
 * find the smallest divisor given a threshold
 *  
 */
import java.util.Scanner;

public class Revision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        // algortihm
        System.out.println(binarysearch(arr, k));
        // lower bound of number
        // lowerbound is defined as smallest index such that arr[i]>=n
        System.out.println("lb?");
        int lowerboundnumber = sc.nextInt();
        System.out.println("lb" + lowerbound(arr, lowerboundnumber));
        // uperbound is definded as smallest index such that arr[i]>n
        System.out.println("up?");
        int uperboudner = sc.nextInt();
        System.out.println("up" + upperbound(arr, uperboudner));
        // floor of a number is defined as largest number such that arr[i]<=n
        System.out.println("floor?");
        int floor = sc.nextInt();
        System.out.println("floor" + floor(arr, floor));
        // ceil of anumbet is defined as smallest number such that arr[i]>=n
        System.out.println("ceil?");
        int ceil = sc.nextInt();
        System.out.println("ceil" + lowerbound(arr, ceil));

        sc.close();
    }

    public static int binarysearch(int arr[], int k) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == k)
                return mid;
            else if (arr[mid] > k)
                high = mid - 1;
            else
                low = mid + 1;

        }
        return -1;
    }

    public static int lowerbound(int arr[], int n) {
        int low = 0, high = arr.length - 1;
        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= n) {
                ans = arr[mid];
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }

    public static int upperbound(int arr[], int n) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > n) {
                ans = arr[mid];
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }

    public static int floor(int a[], int q) {
        int low = 0, high = a.length - 1;
        int ans = Integer.MIN_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] <= q) {
                ans = a[mid];
                low = mid + 1;
            } else
                high = mid - 1;
        }

        return ans;
    }
}