package mandatory.test;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {


    public int playerAmount;
    public int startLife;
    public int life;
    public String name;
    HashMap<String, Integer> playerLife = new HashMap<String, Integer>();
    HashMap<String, String> playerNames = new HashMap<String, String>();

    public HashMap<String, String> getPlayerNames() {
        return playerNames;
    }

    public int getLife() {
        return life;
    }

    public void setStartLife(int startLife){
        this.startLife = startLife;
    }

    public HashMap<String, Integer> getPlayerLife() {
        return playerLife;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayerAmount(int playerAmount) {
        this.playerAmount = playerAmount;
    }



    public Game() {
    }

    public int addPlayers(int playerInput){

        for (int i = 0; i < playerInput; i++) {

            if(playerInput <= 6 && playerInput > 0){

                playerLife.put("Player " + (i + 1), getLife());
                playerNames.put("Player " + (i + 1), "Player " + (i + 1));
            }
            setPlayerAmount(playerInput);
        }
        System.out.println(playerInput + " players added");
        System.out.println(getPlayerLife());
        return playerInput;
    }



    public int addStartLife(int lifeInput){

        if(lifeInput <= 500 && lifeInput >= 0){
            setLife(lifeInput);
            setStartLife(lifeInput);
        }
        else{
            IllegalArgumentException exception = new IllegalArgumentException("Please select a start life between 0-500");
            System.out.println("Wrong input");
            throw exception;
        }
        System.out.println(life);
        return lifeInput;
    }

    public String addName(String player, String name){

        //pattern to find if there is any special character in string
        Pattern regex = Pattern.compile("[^a-zA-Z0-9]");
        //matcher to find if there is any special character in string
        Matcher matcher = regex.matcher(name);

        if(name.length() <= 16 && !matcher.find()) {
            for(String key : getPlayerNames().keySet()) {
                if (key.equals(player)) {
                    playerNames.put(key, name);
                    System.out.println("added name: "+ name +", to: " + player);
                    setName(name);
                }
            }

        } else if (name.length() > 16){
            IllegalArgumentException exception = new IllegalArgumentException("The name is too long - please choose a shorter one");
            throw exception;
        } else if(matcher.find()){
            IllegalArgumentException exception = new IllegalArgumentException("The name can't contain special characters - please choose another");
            throw exception;
        }
        System.out.println(playerNames);
        return name;
    }



    public int addLife(String player) {

        for(String key : getPlayerLife().keySet()) {
            if (key.equals(player)) {
                playerLife.put(key, playerLife.get(key) + 1);
                System.out.println("added life to " + player);
                setLife(playerLife.get(key));
            }
        }
        System.out.println(playerLife);
        System.out.println(player + ": " + life);
        return life;
    }

    public int removeLife(String player) {

        for(String key : getPlayerLife().keySet()) {
            if (key.equals(player)) {
                playerLife.put(key, playerLife.get(key) -1);
                System.out.println("removed life from " + player);
                setLife(playerLife.get(key));
            }

        }

        System.out.println(playerLife);
        System.out.println(player + ": " + life);
        return life;
    }

    public int resetLife(){
        life = startLife;

        for(String key : getPlayerLife().keySet()) {
            playerLife.put(key, life);
        }
        System.out.println(playerLife);
        System.out.println("Life reset to start");
        return life;
    }


}
