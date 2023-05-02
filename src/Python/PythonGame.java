package Python;

import java.util.Scanner;

public class PythonGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",\\s+");

        char[][] matrix = new char[n][n];
        // fill матрицата
        for (int row = 0; row < n; row++) {
            matrix[row] = scanner.nextLine().replaceAll(" ", "").toCharArray();
        }

        //find Python(snake)
        //find all food
        int countFood = 0;
        int rowPython = 0;
        int colPython = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                char currentElement = matrix[row][col];
                if (currentElement == 's') {
                    rowPython = row;
                    colPython = col;
                } else if (currentElement == 'f') {
                    countFood++;
                }
            }
        }
        //moves
        int length = 1;
        boolean isDead = false;
        for (String command : commands) {
            matrix[rowPython][colPython] = '*';
            //left/right/up/down
            switch (command) {
                case "left":
                    colPython--;
                    break;
                case "right":
                    colPython++;
                    break;
                case "up":
                    rowPython--;
                    break;
                case "down":
                    rowPython++;
                    break;
            }

            if (rowPython < 0 || rowPython >= n) {
                if (rowPython < 0) {
                    rowPython = n - 1;
                }

                if (rowPython >= n) {
                    rowPython = 0;
                }
            }

            if (colPython < 0 || colPython >= n) {
                if (colPython < 0) {
                    colPython = n - 1;
                }
                if (colPython >= n) {
                    colPython = 0;
                }
            }

            if (countFood == 0) {
                break;
            }
            //check where is the snake
            if (matrix[rowPython][colPython] == 'f') {
                length++;
                countFood--;
            }

            if (matrix[rowPython][colPython] == 'e') {

                isDead = true;
                break;
            }
            matrix[rowPython][colPython] = 's';
        }
        if (countFood == 0) {
            System.out.println("You win! Final python length is " + length);
        } else if (isDead) {
            System.out.println("You lose! Killed by an enemy!");
        } else {
            System.out.printf("You lose! There is still %d food to be eaten.", countFood);
        }

    }
}

    /*
            Input examples :                                       expected output:

              5                                                     You win! Final python length is 3
              up, right, right, right, up
              * * e * *
              * * * f *
              * f * * *
              s * * * *
              * * e * *

              4                                                     You lose! Killed by an enemy!
              right, right, right, right, right, down, right
              * s * *
              * * e *
              * f * f
              * * * f

              6                                                         You lose! There is still 1 food to be eaten.
              down, left, left, down, right, right, right, right, right
              * * * * s *
              * e f * * *
              f * * * * *
              * * * f e *
              * e * * * *
              * * * * * *

        */

