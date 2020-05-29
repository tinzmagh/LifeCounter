package mandatory.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {

    Game game = new Game();


    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/game")
    public String game(){
        return "game";
    }

    @PostMapping("/remove-Life")
    public @ResponseBody int removeLife(String player){
        return game.removeLife(player);
    }

    @PostMapping("/add-Life")
    public @ResponseBody int addLife(String player){
        return game.addLife(player);
    }

    @PostMapping("/reset-Life")
    public @ResponseBody int resetLife(){
        return game.resetLife();
    }

    @PostMapping("/add-StartLife")
    public @ResponseBody int addStartLife(int life){
        return game.addStartLife(life);
    }

    @PostMapping("/add-Players")
    public @ResponseBody int addPlayers(int players){
        return game.addPlayers(players);
    }

    @PostMapping("/add-Name")
    public @ResponseBody String addName(String player, String name){
        return game.addName(player, name);
    }

    @PostMapping("/roll-Dice")
    public @ResponseBody int rollDice(int playerAmount){
        return game.rollDice(playerAmount);
    }




}
