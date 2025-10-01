import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlgoTests {
    long stopwatch;
    Board firstRowWinsMatrix = new Board(
            new String[][]{
                    {"x","x","x"},
                    {" "," "," "},
                    {" "," "," "}
            });

    Board firstColWinsMatrix = new Board(
            new String[][]{
                    {"x"," "," "},
                    {"x"," "," "},
                    {"x"," "," "}
            });

    Board mainDiaWinsMatrix = new Board(
            new String[][]{
                    {"x"," "," "},
                    {" ","x"," "},
                    {" "," ","x"}
            });

    Board loserCrossMatrix = new Board(
            new String[][]{
                    {" ","o"," "},
                    {"o","x","o"},
                    {" ","o"," "}
            });

    @BeforeEach
    public void setTimer(){
        stopwatch = System.currentTimeMillis();
    }

    @Test
    public void rowWinTest(){
        Main.board = firstRowWinsMatrix;
        Assertions.assertTrue(Main.checkForWin(1,1));
        System.out.printf("rowWinTest completed: %d ms%n",System.currentTimeMillis()-stopwatch);
    }

    @Test
    public void colWinTest(){
        Main.board = firstColWinsMatrix;
        Assertions.assertTrue(Main.checkForWin(1,1));
        System.out.printf("colWinTest completed: %d ms%n",System.currentTimeMillis()-stopwatch);
    }

    @Test
    public void mainDiaWinTest(){
        Main.board = mainDiaWinsMatrix;
        Assertions.assertTrue(Main.checkForWin(1,1));
        System.out.printf("mainDiaWinTest completed: %d ms%n",System.currentTimeMillis()-stopwatch);
    }

    @Test
    public void loserCrossTest(){
        Main.board = loserCrossMatrix;
        Assertions.assertFalse(Main.checkForWin(2,2));
        System.out.printf("loserCross completed: %d ms%n",System.currentTimeMillis()-stopwatch);
    }


}