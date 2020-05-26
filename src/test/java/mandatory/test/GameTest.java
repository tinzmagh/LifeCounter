package mandatory.test;

import org.junit.jupiter.api.Test;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {



    // MISSING
//    ? - Test to check that the game board is over when life count is 0
//    ? - The test to check start new game
//    ? - The test to check life count adjustment
//    ? - The test to check start ‘dice’ rolled and making sure the random number is between 1 and amount of players


    @Test
    void addPlayers() {

        ArrayList<Integer> validInputs = new ArrayList<Integer>( Arrays.asList(2, 4, 6));
        ArrayList<Integer> validOutputs = new ArrayList<Integer>( Arrays.asList(2, 4, 6));
        ArrayList<Integer> invalidInputs = new ArrayList<Integer>( Arrays.asList(-1, 0, 7));

        Game game = new Game();

        // Checking if valid inputs passes

        for(int i = 0; i<validInputs.size(); i++) {
            assertEquals(game.addPlayers(validInputs.get(i)), validOutputs.get(i));
            game.setPlayerAmount(0);
        }

        // Checking if invalid inputs throws an exception

        for(int i = 0; i <invalidInputs.size(); i++) {
            int finalI = i;
            assertThrows(IllegalArgumentException.class, () -> game.addPlayers(invalidInputs.get(finalI)));
        }
    }

    @Test
    void addStartLife() {

        ArrayList<Integer> validInputs = new ArrayList<Integer>( Arrays.asList(1, 2, 50, 99, 100));
        ArrayList<Integer> validOutputs = new ArrayList<Integer>( Arrays.asList(1, 2, 50, 99, 100));
        ArrayList<Integer> invalidInputs = new ArrayList<Integer>( Arrays.asList(-1, 0, 101, 149));

        Game game = new Game();

        // Checking if valid inputs passes

        for(int i = 0; i<validInputs.size(); i++) {
            assertEquals(game.addStartLife(validInputs.get(i)), validOutputs.get(i));
            game.setStartLife(0);
        }

        // Checking if invalid inputs throws an exception

        for(int i = 0; i <invalidInputs.size(); i++) {
            int finalI = i;
            assertThrows(IllegalArgumentException.class, () -> game.addStartLife(invalidInputs.get(finalI)));
        }

    }

    @Test
    void addName() {

        ArrayList<String> validInputs = new ArrayList<String>( Arrays.asList("martine", "VERONIQUE", "steFFen", "Phillip"));
        ArrayList<String> validOutputs = new ArrayList<String>( Arrays.asList("martine", "VERONIQUE", "steFFen", "Phillip"));
        ArrayList<String> invalidInputs = new ArrayList<String>( Arrays.asList("", "hanne123", "kar!", "F**k", "maaaaaaaaaaaaaaaaaartaaaaa"));

        Game game = new Game();

        // Checking if valid inputs passes

        for(int i = 0; i<validInputs.size(); i++) {
            assertEquals(game.addName("Player 1", validInputs.get(i)), validOutputs.get(i));
            game.setName(null);
        }

        // Checking if invalid inputs throws an exception

        for(int i = 0; i <invalidInputs.size(); i++) {
            int finalI = i;
            assertThrows(IllegalArgumentException.class, () -> game.addName("Player", invalidInputs.get(finalI)));
        }
    }

    @Test
    void addLife() {

        // Checking if valid inputs passes

        Game game = new Game();

        game.playerLife.put("Player 1", 0);
        game.playerLife.put("Player 2", 1);
        game.playerLife.put("Player 3", 350);
        game.playerLife.put("Player 4", 499);

        ArrayList<Integer> validOutputs = new ArrayList<Integer>( Arrays.asList(1, 2, 351, 500));


        for(int i = 0; i <game.playerLife.size(); i++) {
            for(String key : game.getPlayerLife().keySet()) {
                if (key.equals("Player " + (i+1))) {

                    assertEquals(game.addLife("Player " + (i+1)), validOutputs.get(i));
                }
            }
        }

        // Checking if invalid inputs throws an exception

        Game game1 = new Game();
        game1.playerLife.put("Player 1", 500);
        game1.playerLife.put("Player 2", 600);
        game1.playerLife.put("Player 3", 1050);


        for(int i = 0; i <game1.playerLife.size(); i++) {
            int finalI = i;

            assertThrows(IllegalArgumentException.class, () -> game1.addLife("Player " + (finalI + 1)));
        }

    }

    @Test
    void removeLife() {

        // Checking if valid inputs passes

        Game game = new Game();

        game.playerLife.put("Player 1", 500);
        game.playerLife.put("Player 2", 99);
        game.playerLife.put("Player 3", 50);
        game.playerLife.put("Player 4", 1);

        ArrayList<Integer> validOutputs = new ArrayList<Integer>( Arrays.asList(499, 98, 49, 0));


        for(int i = 0; i <game.playerLife.size(); i++) {
            for(String key : game.getPlayerLife().keySet()) {
                if (key.equals("Player " + (i+1))) {

                    assertEquals(game.removeLife("Player " + (i+1)), validOutputs.get(i));

                }

            }
        }

        // Checking if invalid inputs throws an exception

        Game game1 = new Game();
        game1.playerLife.put("Player 1", -1);
        game1.playerLife.put("Player 2", -5);
        game1.playerLife.put("Player 3", -100);


        for(int i = 0; i <game1.playerLife.size(); i++) {
            int finalI = i;

            assertThrows(IllegalArgumentException.class, () -> game1.removeLife("Player " + (finalI + 1)));
        }

    }

    @Test
    void resetLife() {

        // Checking if valid inputs passes

        Game game = new Game();

        game.setStartLife(100);

        game.playerLife.put("Player 1", 234);
        game.playerLife.put("Player 2", 100);
        game.playerLife.put("Player 3", 49);
        game.playerLife.put("Player 4", 0);

        System.out.println(game.playerLife);
        assertEquals(game.resetLife(), 100);

    }
}