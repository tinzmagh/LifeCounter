package mandatory.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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





    @Test
    void addPlayers() {
        Game game = new Game();
        // When maximum amount of players is exceeded
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> game.addPlayers(9));

        // Then exeption error is shown


        // Checks if valid inputs passes

        Purchase purchase1 = new Purchase(false, 1, cellphones, 0);
        assertEquals(150, purchase1.addPhoneLine());

        Purchase purchase2 = new Purchase(false, 5, cellphones, 0);
        assertEquals(150, purchase2.addPhoneLine());
    }

    @Test
    void addStartLife() {
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