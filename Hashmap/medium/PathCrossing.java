/*
 * https://leetcode.com/problems/path-crossing/description/
 */
class Solution {
    public boolean isPathCrossing(String path) {
    int x = 0, y = 0;
        Set<String> visited = new HashSet<>();
        visited.add("0,0");

        for (int i = 0; i < path.length(); i++) {
            char dir = path.charAt(i);
            if (dir == 'E') {
                x++;
            } else if (dir == 'W') {
                x--;
            } else if (dir == 'N') {
                y++;
            } else if (dir == 'S') {
                y--;
            }

            String pos = x + "," + y;
            if (visited.contains(pos)) {
                return true;
            }

            visited.add(pos);
        }

        return false;
    }
}