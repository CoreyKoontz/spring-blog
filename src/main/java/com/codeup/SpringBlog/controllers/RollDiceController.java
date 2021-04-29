package com.codeup.SpringBlog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.ThreadLocalRandom;

@Controller
public class RollDiceController {

    public int getRandomNum() {
        return ThreadLocalRandom.current().nextInt(1, 6 + 1);
    }

    @GetMapping("/roll-dice")
    public String rollDice() {
        return "roll-dice";
    }


    @PostMapping("/roll-dice")
    public String results(@RequestParam(name = "userInput") String userInput, Model model) {
        int randomNum = getRandomNum();
        model.addAttribute("userInput", userInput);
        model.addAttribute("randomNumber",  randomNum);

        if (Integer.parseInt(userInput) == (randomNum)) {
            model.addAttribute("isMatch", "YOU WIN!");
        } else {
            model.addAttribute("isMatch", "Try Again.");
        }

        return "/roll-dice";
    }
}
