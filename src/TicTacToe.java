
import java.io.*;

public class TicTacToe {

    static int[][] grid;	
    static Board b;
    static int[][] board;

    public static final int PLAYER_ONE = 1;
    public static final int PLAYER_TWO = 2;

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Coordinate c;
        int counter = 1;
        grid = new int[3][3];
        b = new Board(3, 3);

        File file = new File("BoardTTT/Tip.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        while ((str = br.readLine()) != null) {

        	b.displayMessage(str);
    }

        while (!checkHorizontal() && !checkVertical() && !checkDiagonal()) {
            int row, col;

            c = b.getClick();
            row = c.getRow();
            col = c.getCol();

            if (counter == 1 || counter == 3 || counter == 5 || counter == 7 || counter == 9) {

                b.putPeg("red", row, col);
                grid[row][col] = 1;
                counter = counter + 1;

            } else if (counter == 2 || counter == 4 || counter == 6 || counter == 8 || counter == 10) {

                b.putPeg("black", row, col);
                grid[row][col] = 2;
                counter = counter + 1;

            }

        }

    }

    public static boolean checkHorizontal() {
    	
        if (grid[0][0] == PLAYER_ONE && grid[0][1] == PLAYER_ONE && grid[0][2] == PLAYER_ONE || grid[0][0] == PLAYER_TWO && grid[0][1] == PLAYER_TWO && grid[0][2] == PLAYER_TWO) {
            b.drawLine(0, 0, 0, 2);
            return true;

        } else if (grid[1][0] == PLAYER_ONE && grid[1][1] == PLAYER_ONE && grid[1][2] == PLAYER_ONE || grid[1][0] == PLAYER_TWO && grid[1][1] == PLAYER_TWO && grid[1][2] == PLAYER_TWO) {
            b.drawLine(1, 0, 1, 2);
            return true;

        } else if (grid[2][0] == PLAYER_ONE && grid[2][1] == PLAYER_ONE && grid[2][2] == PLAYER_ONE || grid[2][0] == PLAYER_TWO && grid[2][1] == PLAYER_TWO && grid[2][2] == PLAYER_TWO) {
            b.drawLine(2, 0, 2, 2);
            return true;

        }
        return false;
    }
    
    public static boolean checkVertical() {
        if (grid[0][0] == PLAYER_ONE && grid[1][0] == PLAYER_ONE && grid[2][0] == PLAYER_ONE || grid[0][0] == PLAYER_TWO && grid[1][0] == PLAYER_TWO && grid[2][0] == PLAYER_TWO) {
            b.drawLine(0, 0, 2, 0);
            return true;

        } else if (grid[0][1] == PLAYER_ONE && grid[1][1] == PLAYER_ONE && grid[2][1] == PLAYER_ONE || grid[0][1] == PLAYER_TWO && grid[1][1] == PLAYER_TWO && grid[2][1] == PLAYER_TWO) {
            b.drawLine(0, 1, 2, 1);
            return true;

        } else if (grid[0][2] == PLAYER_ONE && grid[1][2] == PLAYER_ONE && grid[2][2] == PLAYER_ONE || grid[0][2] == PLAYER_TWO && grid[1][2] == PLAYER_TWO && grid[2][2] == PLAYER_TWO) {
            b.drawLine(0, 2, 2, 2);
            return true;

        }
        return false;
    }
    
    public static boolean checkDiagonal() {

        if (grid[0][0] == PLAYER_ONE && grid[1][1] == PLAYER_ONE && grid[2][2] == PLAYER_ONE || grid[0][0] == PLAYER_TWO && grid[1][1] == PLAYER_TWO && grid[2][2] == PLAYER_TWO) {
            b.drawLine(0, 0, 2, 2);
            return true;

        } else if (grid[2][0] == PLAYER_ONE && grid[1][1] == PLAYER_ONE && grid[0][2] == PLAYER_ONE || grid[2][0] == PLAYER_TWO && grid[1][1] == PLAYER_TWO && grid[0][2] == PLAYER_TWO) {
            b.drawLine(0, 2, 2, 0);
            return true;
        }
        return false;
    }

}