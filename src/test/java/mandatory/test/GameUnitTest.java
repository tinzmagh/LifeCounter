package mandatory.test;


import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GameUnitTest {

    Game game = new Game();


    @Before
    public void setUp(){
        game = new Game();
    }

    @Test
    void addPlayers() {

        ArrayList<Integer> validInputs = new ArrayList<Integer>( Arrays.asList(2, 4, 6));
        ArrayList<Integer> validOutputs = new ArrayList<Integer>( Arrays.asList(2, 4, 6));
        ArrayList<Integer> invalidInputs = new ArrayList<Integer>( Arrays.asList(-1, 0, 7));

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

        ArrayList<String> validInputs = new ArrayList<String>( Arrays.asList("martine magh", "VERONIQUE", "steFFen24", "P"));
        ArrayList<String> validOutputs = new ArrayList<String>( Arrays.asList("martine magh", "VERONIQUE", "steFFen24", "P"));
        ArrayList<String> invalidInputs = new ArrayList<String>( Arrays.asList("", "kar#", "stef@", "!", "maaaaaaaaaaaaaaaaarta"));


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
    void addLifeIncrement() {

        // Checking if valid inputs passes, and increments with 1.

        // Data provider
        ArrayList<Integer> validInputs = new ArrayList<Integer>( Arrays.asList(1, 350, 499));
        ArrayList<Integer> validOutputs = new ArrayList<Integer>( Arrays.asList(2, 351, 500));


        for (int i = 0; i < validInputs.size(); i++) {
            game.playerLife.put("Player " + (i + 1), validInputs.get(i));
            game.playerLife.put("Player " + (i + 1), validInputs.get(i));
            game.playerLife.put("Player " + (i + 1), validInputs.get(i));
        }

        for(int i = 0; i <game.playerLife.size(); i++) {
            for(String key : game.getPlayerLife().keySet()) {
                if (key.equals("Player " + (i+1))) {

                    assertEquals(game.addLife("Player " + (i+1)), validOutputs.get(i));

                }
            }
        }
    }

    @Test
    void upperLifeBoundary(){
        // Checking if invalid inputs throws an exception
        // Data provider
        ArrayList<Integer> validInputs = new ArrayList<Integer>( Arrays.asList(0, 500, 600));

        for (int i = 0; i < validInputs.size(); i++) {
            game.playerLife.put("Player " + (i + 1), validInputs.get(i));
            game.playerLife.put("Player " + (i + 1), validInputs.get(i));
            game.playerLife.put("Player " + (i + 1), validInputs.get(i));
        }

        for(int i = 0; i <game.playerLife.size(); i++) {
            int finalI = i + 1;

            assertThrows(IllegalArgumentException.class, () -> game.addLife("Player " + (finalI)));
        }
    }

    @Test
    void lowerLifeBoundary(){
        // Data provider
        ArrayList<Integer> validInputs = new ArrayList<Integer>( Arrays.asList(-1, -5, -100));

        for (int i = 0; i < validInputs.size(); i++) {
            game.playerLife.put("Player " + (i + 1), validInputs.get(i));
            game.playerLife.put("Player " + (i + 1), validInputs.get(i));
            game.playerLife.put("Player " + (i + 1), validInputs.get(i));
        }

        for(int i = 0; i <game.playerLife.size(); i++) {
            int finalI = i;

            assertThrows(IllegalArgumentException.class, () -> game.removeLife("Player " + (finalI + 1)));
        }

    }

    @Test
    void removeLifeDecrement() {

        // Checking if valid inputs passes, and decreases with 1.

        // Data providers
        ArrayList<Integer> validInputs = new ArrayList<Integer>( Arrays.asList(500, 200, 1));
        ArrayList<Integer> validOutputs = new ArrayList<Integer>( Arrays.asList(499, 199, 0));

        for (int i = 0; i < validInputs.size(); i++) {
            game.playerLife.put("Player " + (i + 1), validInputs.get(i));
            game.playerLife.put("Player " + (i + 1), validInputs.get(i));
            game.playerLife.put("Player " + (i + 1), validInputs.get(i));
        }


        for(int i = 0; i <game.playerLife.size(); i++) {
            for(String key : game.getPlayerLife().keySet()) {
                if (key.equals("Player " + (i+1))) {

                    assertEquals(game.removeLife("Player " + (i+1)), validOutputs.get(i));
                }

            }
        }

    }

    @Test
    void resetLife() {

        // Checking if valid inputs passes

        game.setStartLife(100);

        game.playerLife.put("Player 1", 234);
        game.playerLife.put("Player 2", 100);
        game.playerLife.put("Player 3", 49);
        game.playerLife.put("Player 4", 0);

        System.out.println(game.playerLife);
        assertEquals(game.resetLife(), 100);

    }

    @Test
    void rollDice() {

        ArrayList<Integer> validInputs = new ArrayList<>( Arrays.asList(1, 2, 3, 4, 5, 6));


        // We do it 50 times to ensure that the test doesn't just pass based on chance.
        for (int j = 0; j < 50; j++) {

            for (int i = 0; i < validInputs.size(); i++) {

                game.setPlayerAmount(validInputs.get(i));
                int min = 1;
                int max = validInputs.get(i);
                int dice = game.rollDice(validInputs.get(i));

                assertTrue(dice >= min && dice <= max);
            }

        }

    }
}