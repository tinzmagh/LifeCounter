package mandatory.test;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class PurchaseTest {

    ArrayList<String> cellPhones = new ArrayList<String>( Arrays.asList("Motorola G99", "iPhone 99", "Samsung Galaxy 99", "Sony Xperia 99", "Huawei 99"));
    ArrayList<Integer> cellPhonePrices = new ArrayList<Integer>( Arrays.asList(800, 6000, 1000, 900, 900));

    @Test
    void checkInternetConnection() {

        // Given parameters
        // From start
        Purchase purchase = new Purchase();
        // When internet Connection boolean touched
        Purchase purchaseCheck = new Purchase(false, 0, null, 0);
        // Then Expected Test True
        assertFalse(purchase.internetConnection);
        // Then Expected price to be price + 200
        assertEquals(purchase.price + 200, purchaseCheck.checkInternetConnection(true));
        // Then Expected price to be price - 200
        assertEquals(purchase.price, purchaseCheck.checkInternetConnection(false));

    }

    @Test
    void addPhoneLine() {

        // Tests if invalid inputs raises an error

            // Given parameters
            ArrayList<String> cellphones = new ArrayList<>();
            Purchase purchase = new Purchase(false, 9, cellphones, 0);
            // When maximum of phonelines is exceeded
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> purchase.addPhoneLine());
            // Then exeption error is shown
            assertEquals("8 phone lines is the maximum", exception.getMessage());

        // Checks if valid inputs passes

            Purchase purchase1 = new Purchase(false, 1, cellphones, 0);
            assertEquals(150, purchase1.addPhoneLine());

            Purchase purchase2 = new Purchase(false, 5, cellphones, 0);
            assertEquals(150, purchase2.addPhoneLine());

    }

    @Test
    void removePhoneLine() {

        // Tests if invalid inputs raises an error

            // Given parameters
            ArrayList<Integer> invalidAmountOfPhonelines = new ArrayList<>( Arrays.asList(-1, -5, -100, 10));
            ArrayList<String> cellphones = new ArrayList<>();
            Purchase purchase = new Purchase();


            int i;
            for (i = 0; i < invalidAmountOfPhonelines.size(); i++) {

                // When minimum of phone lines is exceeded
                Throwable exception = assertThrows(IllegalArgumentException.class, () -> purchase.removePhoneLine());
                // Then exeption error is shown
                assertEquals("0 phone lines is the minimum", exception.getMessage());

            }

        // Checks if valid inputs passes

            Purchase purchase1 = new Purchase(false, 1, cellphones, 0);
            assertEquals(-150, purchase1.removePhoneLine());

            Purchase purchase2 = new Purchase(false, 5, cellphones, 0);
            assertEquals(-150, purchase2.removePhoneLine());

            Purchase purchase3 = new Purchase(false, 8, cellphones, 0);
            assertEquals(-150, purchase3.removePhoneLine());
    }


    @Test
    void addCellPhone() {
    // Check that the addCellPhone method returns the appropriate price for each corresponding phone
        Purchase purchase = new Purchase();
        int i;

        for(i = 0; i<cellPhones.size(); i++) {
            assertEquals(purchase.addCellPhone(cellPhones.get(i)), cellPhonePrices.get(i));
            purchase.price = 0;
        }
    }

    @Test
    void removeCellPhone() {

        Purchase purchase = new Purchase();

        int i;
        for(i = 0; i < cellPhones.size(); i++) {
            purchase.addCellPhone(cellPhones.get(i));
            assertEquals(purchase.removeCellPhone(cellPhones.get(i)), purchase.price);
        }
    }

    @Test
    void buy() {
        Purchase purchase = new Purchase();
        purchase.checkInternetConnection(true);
        purchase.addPhoneLine();
        purchase.addCellPhone("iPhone 99");

        assertEquals("\nYour Cart: \n\n" + "Internet Connection: 200 DKK\n" + "1 Phone lines: 150\n" + "iPhone 99: 6000 DKK\n" + "\nTotal price: 6350DKK", purchase.buy());
        assertEquals(purchase.price, 6350);

        purchase.addPhoneLine();
        assertEquals(purchase.price, 6500);

        purchase.removeCellPhone("iPhone 99");
        assertEquals(purchase.price, 500);
    }
}