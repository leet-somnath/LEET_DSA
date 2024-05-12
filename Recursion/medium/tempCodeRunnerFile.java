static ArrayList<Integer> arrs = new ArrayList<>();
static int c=0;
    public static void subseqgen(int[] arr, int i, int k, int sum) {
        if (i == arr.length) {
            if (sum == k) {
                for (Integer y : arrs)
                    System.out.print(y + " ");
                System.out.println();
                c++;
            }
            return;
        }

        // Include the current element
        sum += arr[i];
        arrs.add(arr[i]);
        subseqgen(arr, i + 1, k, sum);
        sum -= arr[i];
        // Exclude the current element
        arrs.remove(arrs.size() - 1);
        subseqgen(arr, i + 1, k, sum);
    }
}