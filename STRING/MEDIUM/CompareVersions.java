class Solution {
    public int compareVersion(String version1, String version2) {
    String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        // Get the maximum length of both version parts
        int maxLength = Math.max(v1.length, v2.length);

        // Loop through each revision and compare them
        for (int i = 0; i < maxLength; i++) {
            // Get the revision for version1 and version2, treating missing parts as "0"
            int rev1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int rev2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;

            // Compare the revisions
            if (rev1 < rev2) {
                return -1;
            } else if (rev1 > rev2) {
                return 1;
            }
        }

        // If all revisions are equal, return 0
        return 0;
    }
}