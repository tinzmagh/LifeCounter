package mandatory.test;

import org.junit.jupiter.api.Test;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

//    1. The test to check valid amount of players input
//    2. The test to check valid life amount input
//    3. The test to check valid player names input
//    4. The test to check max life count
//    5. The test to check min life count and that the game board is over when life count is 0
//    6. The test to check reset life count and making sure that only life count is reset.

//    ? - The test to check start new game
//    ? - The test to check life count adjustment
//    ? - The test to check start ‘dice’ rolled and making sure the random number is between 1 and amount of players


    @Rule
    public ExpectedException exception = ExpectedException.none();


    @Test
    void addPlayers() {

        ArrayList<Integer> validInputs = new ArrayList<Integer>( Arrays.asList(2, 4, 6));
        ArrayList<Integer> validOutputs = new ArrayList<Integer>( Arrays.asList(2, 4, 6));

        Game game = new Game();

        for(int i = 0; i<validInputs.size(); i++) {
            assertEquals(game.addPlayers(validInputs.get(i)), validOutputs.get(i));
            game.setPlayerAmount(0);
        }

        Throwable exception1 = assertThrows(IllegalArgumentException.class, () -> game.addPlayers(-1));
        Throwable exception2 = assertThrows(IllegalArgumentException.class, () -> game.addPlayers(0));
        Throwable exception3 = assertThrows(IllegalArgumentException.class, () -> game.addPlayers(7));

        assertEquals("Maximum amount of players is 6", exception1.getMessage());
        assertEquals("Maximum amount of players is 6", exception2.getMessage());
        assertEquals("Maximum amount of players is 6", exception3.getMessage());

    }

    @Test
    void addStartLife() {

        ArrayList<Integer> validInputs = new ArrayList<Integer>( Arrays.asList(1, 2, 50, 99, 100));
        ArrayList<Integer> validOutputs = new ArrayList<Integer>( Arrays.asList(1, 2, 50, 99, 100));

        Game game = new Game();

        for(int i = 0; i<validInputs.size(); i++) {
            assertEquals(game.addStartLife(validInputs.get(i)), validOutputs.get(i));
            game.setStartLife(0);
        }



    }

    @Test
    void addName() {
    }

    @Test
    void addLife() {
    }

    @Test
    void removeLife() {
    }

    @Test
    void resetLife() {
    }
}