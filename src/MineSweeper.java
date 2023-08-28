import java.util.Scanner;
import java.util.Random;
public class MineSweeper {
    int col;
    int row;
    int mineNum;
    int opened;
    String[][] field;
    String[][] gameField;

    Scanner take = new Scanner(System.in);
    public MineSweeper(int col, int row){
        this.col=col;
        this.row=row;
        this.mineNum = (col*row/4);
    }
    public String[][] creator()
    {
        this.field = new String[this.row+2][this.col+2];
        for (int i=0;i < field.length;i++)
        {
            for (int j = 0; j<field[0].length;j++)
            {
                field[i][j] = "-";
            }
        }
        Random r = new Random();
        for(int q =0 ; q <this.mineNum; q++){
            int n1 = r.nextInt(1,this.col-1);
            int n2 = r.nextInt(1,this.row-1);
            this.field[n2][n1]="*";
        }
        return this.field;
    }
    public void initSet()
    {
        this.gameField = new String[this.row+2][this.col+2];
        for (int i=0;i < gameField.length;i++)
        {
            for (int j = 0; j<gameField[0].length;j++)
            {
                gameField[i][j] = "-";
            }
        }
        //return gameField;
    }
    public boolean gameMake()
    {
        System.out.println("Enter row num: ");
        int rowNum = take.nextInt();
        System.out.println("Enter col num: ");
        int colNum = take.nextInt();
        colNum+=1;
        rowNum+=1;
        if(field[rowNum][colNum].equals("*")){
            System.out.println("You Lost");
            return false;
        }
        int bombCount=0;
        //if (rowNum-1 >=0 && rowNum+1<=this.row-1 && colNum-1 >= 0 && colNum+1<=this.col-1)
        {
            if(this.field[rowNum+1][colNum].equals("*")){
                bombCount++;
            }
            if(this.field[rowNum][colNum+1].equals("*")){
                bombCount++;
            }
            if(this.field[rowNum+1][colNum+1].equals("*")){
                bombCount++;
            }
            if(this.field[rowNum-1][colNum+1].equals("*")){
                bombCount++;
            }
            if(this.field[rowNum-1][colNum].equals("*")){
                bombCount++;
            }
            if(this.field[rowNum-1][colNum-1].equals("*")){
                bombCount++;
            }
            if(this.field[rowNum][colNum-1].equals("*")){
                bombCount++;
            }
            if(this.field[rowNum+1][colNum-1].equals("*")){
                bombCount++;
            }
            gameField[rowNum][colNum]=String.valueOf(bombCount);
            this.opened++;
            return true;
        }
        //return true;
    }

    public boolean isWon()
    {
        if (this.opened == (this.row*this.col)-this.mineNum){
            System.out.println("You Won");
            return false;
        }
        return true;
    }
    public void writer(String[][] arr){
        for (int i=0;i < arr.length;i++)
        {
            for (int j = 0; j<arr[0].length;j++)
            {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
    public void gameWriter(String[][] arr){
        for(int i = 1; i< arr.length-1;i++){
            for(int j=1;j<arr[0].length-1;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

}
