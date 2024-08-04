class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        List<String> output = new ArrayList<>();
        backtrack(n, 0, 0, output, result);
        return result;
    }

    public void backtrack(int n, int leftCount, int rightCount, List<String> output, List<String> result) {
        // Base case where count of left and right braces is "n"
        if (leftCount >= n && rightCount >= n) {
            // Join the array elements into a string without any separators.
            String outputStr = String.join("", output);
            result.add(outputStr);
        }

        // Case where we can still append left braces
        if (leftCount < n) {
            output.add("(");
            backtrack(n, leftCount + 1, rightCount, output, result);
            output.remove(output.size() - 1);
        }

        // Case where we append right braces if the current count of right braces is
        // less than the count of left braces
        if (rightCount < leftCount) {
            output.add(")");
            backtrack(n, leftCount, rightCount + 1, output, result);
            output.remove(output.size() - 1);
        }
    }
}