import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        MineSweeper mine = new MineSweeper(3,4);
        mine.creator();
        mine.initSet();
        boolean b = true;
        while (b && mine.isWon())
        {
            //mine.writer(mine.field);
            //System.out.println("======");
            mine.gameWriter(mine.gameField);
            b = mine.gameMake();
        }
    }
}
