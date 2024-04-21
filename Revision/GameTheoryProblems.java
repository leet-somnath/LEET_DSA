import java.util.*;

public class GameTheoryProblems {
    
    // Problem 1: Nim Game
    // Description: Classic Nim game with piles of stones.
    // Rules: Players take turns removing stones from a single pile.
    //        The player who removes the last stone wins.
    // Implementation: Use XOR operation to calculate the Grundy's number.
    //                 If the XOR result is not zero, the first player can win.
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    // Problem 2: Nim Game II
    // Description: Nim game variant where players can take stones from different piles.
    // Rules: Players can remove any number of stones from any single pile in each turn.
    //        The player who removes the last stone wins.
    // Implementation: Use XOR operation on all pile sizes to calculate the Grundy's number.
    //                 If the XOR result is not zero, the first player can win.
    public boolean canWinNimII(int[] piles) {
        int xor = 0;
        for (int pile : piles) {
            xor ^= pile;
        }
        return xor != 0;
    }

    // Problem 3: Wythoff's Game
    // Description: Two players take turns removing stones from two piles.
    // Rules: Players can remove any number of stones from one pile or the same number of stones from both piles.
    //        The player who removes the last stone wins.
    // Implementation: Use Wythoff's theorem to calculate the Grundy's number for each pile.
    //                 If the Grundy's number of both piles is not equal, the first player can win.
    public boolean canWinWythoffsGame(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        int diff = max - min;
        double goldenRatio = (1 + Math.sqrt(5)) / 2;
        int k = (int) (diff * goldenRatio);
        return min != k && max != k;
    }

    // Problem 4: Fibonacci Nim
    // Description: Nim game variant with Fibonacci sequence as the pile sizes.
    // Rules: Players take turns removing stones from piles with Fibonacci sequence sizes.
    //        The player who removes the last stone wins.
    // Implementation: Use Fibonacci sequence to calculate the Grundy's number for each pile.
    public boolean canWinFibonacciNim(int n) {
        int a = 1, b = 1;
        while (n > 0) {
            int temp = b;
            b += a;
            a = temp;
            n -= a;
        }
        return n != 0;
    }

    // Problem 5: Misère Nim
    // Description: Variant of Nim where the last player to take a stone loses.
    // Rules: Same as classic Nim, but the player who removes the last stone loses.
    // Implementation: Handle special case for the last stone to determine the loser.
    public boolean canWinMisereNim(int[] piles) {
        int xor = 0, total = 0;
        for (int pile : piles) {
            xor ^= pile;
            total += pile;
        }
        return !(total == piles.length && xor == 0) && (total % 2 != 0 || xor != 0);
    }

    // Problem 7: Chomp
    // Description: Players take turns eating squares from a grid, avoiding a poisoned square.
    // Rules: Players take turns removing squares from a grid, avoiding the poisoned square.
    //        The player who eats the poisoned square loses.
    // Implementation: Represent the game state as a grid and use Grundy's number to determine winning moves.
    public boolean canWinChomp(int rows, int cols) {
        return (rows - 1) % 2 != 0 || (cols - 1) % 2 != 0;
    }

    // Problem 8: Kayles
    // Description: Players knock down pins in a row, aiming to leave the opponent with a single pin.
    // Rules: Players take turns knocking down pins in a row, aiming to leave the opponent with a single pin.
    //        Each player can knock down adjacent pins.
    // Implementation: Represent the game state as a row of pins and use Grundy's number to determine winning moves.
    public boolean canWinKayles(int[] pins) {
        int grundy = 0;
        for (int i = 0; i < pins.length; i++) {
            if (pins[i] == 1 && (i == 0 || pins[i - 1] != 1)) {
                int j = i;
                while (j < pins.length && pins[j] == 1) {
                    j++;
                }
                grundy ^= (j - i) % 2;
                i = j - 1;
            }
        }
        return grundy != 0;
    }

    // Problem 9: Hackenbush
    // Description: Game played on a graph, where players remove edges to disconnect vertices.
    // Rules: Players take turns removing edges from a graph, aiming to disconnect vertices from a certain point.
    // Implementation: Represent the game as a graph and use Grundy's number to determine winning moves.
    public boolean canWinHackenbush(int[][] edges) {
        // Implementation goes here
        return false;
    }

    // Problem 10: Dawson's Chess
    // Description: Variant of chess played on an infinite grid.
    // Rules: Players take turns moving pieces on an infinite grid according to chess rules.
    //        The player who reaches a certain winning condition wins.
    // Implementation: Use Grundy's number to analyze the game state and determine winning moves.
    public boolean canWinDawsonsChess(int x, int y) {
        return (x + y) % 2 != 0;
    }
      // Problem 11: Colonel Blotto Game
    // Description: Players allocate troops across battlefields to win battles.
    // Rules: Players distribute troops across several battlefields, trying to win as many battles as possible.
    //        The player who wins the majority of battles wins the game.
    // Implementation: Analyze the distribution of troops to determine the winning strategy.
    public boolean canWinColonelBlotto(int[] troopsA, int[] troopsB) {
        int winsA = 0, winsB = 0;
        for (int i = 0; i < troopsA.length; i++) {
            if (troopsA[i] > troopsB[i]) {
                winsA++;
            } else if (troopsA[i] < troopsB[i]) {
                winsB++;
            }
        }
        return winsA > winsB;
    }

    // Problem 12: Domineering
    // Description: Players place dominoes on a grid, trying to block the opponent.
    // Rules: Players take turns placing horizontal or vertical dominoes on a grid.
    //        The player who blocks the opponent from placing a domino wins.
    // Implementation: Analyze the game state to determine winning moves.
    public boolean canWinDomineering(boolean[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int countH = 0, countV = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] && j + 1 < cols && !grid[i][j + 1]) {
                    countH++;
                }
                if (grid[i][j] && i + 1 < rows && !grid[i + 1][j]) {
                    countV++;
                }
            }
        }
        return countH != countV;
    }

    // Problem 13: Snort Game
    // Description: Players take turns removing coins from rows with a maximum limit.
    // Rules: Players take turns removing coins from rows, but they cannot exceed a maximum limit.
    //        The player who removes the last coin wins.
    // Implementation: Analyze the game state to determine winning moves.
    public boolean canWinSnort(int[] rows, int limit) {
        int xor = 0;
        for (int row : rows) {
            xor ^= row % (limit + 1);
        }
        return xor != 0;
    }

    // Problem 17: Silver Dollar Game
    // Description: Players alternate taking pieces from a stack with fixed rules.
    // Rules: Players take turns removing pieces from a stack, following fixed rules for each turn.
    //        The player who removes the last piece wins.
    // Implementation: Analyze the game state to determine winning moves.
    public boolean canWinSilverDollar(int n) {
        return n % 4 != 0;
    }

    // Problem 18: Hales-Jewett Game
    // Description: Two players build a sequence of symbols without creating certain patterns.
    // Rules: Players alternate placing symbols in a sequence, trying to avoid certain patterns.
    //        The player who avoids creating the specified patterns wins.
    // Implementation: Analyze the game state to determine winning moves.
    public boolean canWinHalesJewett(int n, int k) {
        return n % (k + 1) != 0;
    }

    // Problem 19: Galaxy Game
    // Description: Players remove stars from a grid according to specific rules.
    // Rules: Players take turns removing stars from a grid, following specific rules for each turn.
    //        The player who removes the last star wins.
    // Implementation: Analyze the game state to determine winning moves.
    public boolean canWinGalaxy(boolean[][] grid) {
        int count = 0;
        for (boolean[] row : grid) {
            for (boolean star : row) {
                if (star) {
                    count++;
                }
            }
        }
        return count % 2 != 0;
    }


    // Main method for testing
    public static void main(String[] args) {
        // Test each problem here
        GameTheoryProblems game = new GameTheoryProblems();
        Scanner scanner = new Scanner(System.in);

        // Fibonacci Nim
        System.out.println("Enter the number of stones for Fibonacci Nim:");
        int fibStones = scanner.nextInt();
        System.out.println("Fibonacci Nim: " + game.canWinFibonacciNim(fibStones));

        // Misère Nim
        System.out.println("Enter the number of piles for Misère Nim:");
        int numPiles = scanner.nextInt();
        int[] miserePiles = new int[numPiles];
        System.out.println("Enter stone count for each pile:");
        for (int i = 0; i < numPiles; i++) {
            miserePiles[i] = scanner.nextInt();
        }
        System.out.println("Misère Nim: " + game.canWinMisereNim(miserePiles));

        // Chomp
        System.out
