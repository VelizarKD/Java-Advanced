package Python;

import java.util.Scanner;

public class PythonGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String [] commands = scanner.nextLine().split(",\\s+");

        char[][] matrix = new char[n][n];
        // fill матрицата
        for (int row = 0; row < n; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }

        //find Python(snake)
        int rowPython = 0;
        int colPython = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                char currentElement = matrix[row][col];
                if (currentElement == 's') {
                    rowPython = row;
                    colPython = col;
                }
            }
        }
        //moves
        int length = 1;
        for (String command : commands) {
            //left/right/up/down
            switch (command) {
                case "left":
                    colPython--;
                    break;
                case "right":
                    break;
                case "up":
                    break;
                case "down":
                    break;
            }
        }
    }
}
