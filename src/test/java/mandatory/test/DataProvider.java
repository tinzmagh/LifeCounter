package mandatory.test;

import java.util.ArrayList;
import java.util.Arrays;

public class DataProvider {

    ArrayList<Integer> validAmountOfPlayers = new ArrayList<Integer>( Arrays.asList(2, 3, 4, 5, 6));
    ArrayList<Integer> validStartingLife = new ArrayList<Integer>( Arrays.asList(1, 50));

    ArrayList<String> validNames = new ArrayList<String>( Arrays.asList("John Johnson", "Veronique92", "steffen", "P"));
    ArrayList<String> invalidNames = new ArrayList<String>( Arrays.asList("Ka!!?", "", "he**l"));

    ArrayList<Integer> validAddLifeInputs = new ArrayList<Integer>( Arrays.asList(1, 50, 95));
    ArrayList<Integer> validAddLifeOutputs = new ArrayList<Integer>( Arrays.asList(6, 55, 100));

    ArrayList<Integer> validRemoveLifeInputs = new ArrayList<Integer>( Arrays.asList(6, 50, 100));
    ArrayList<Integer> validRemoveLifeOutputs = new ArrayList<Integer>( Arrays.asList(1, 45, 95));







}
