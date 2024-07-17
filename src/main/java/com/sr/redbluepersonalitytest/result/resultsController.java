package com.sr.redbluepersonalitytest.result;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.sr.redbluepersonalitytest.user.User;
import com.sr.redbluepersonalitytest.user.UserService;

@Controller
public class resultsController {
    
    @Autowired
    private answerdataService answerdataService;

    @Autowired
    private UserService userService;

    @PostMapping("/results")
    public String load_results(Model model, @RequestParam (required = false) String initialAnswer, @RequestParam (required = false) String username, @RequestParam (required = false) String selectedOption) {
        //put items on the hidden dashboard (some are not hidden)
        model.addAttribute("name", username);
        String finalanswers = (initialAnswer + "," + selectedOption).substring(1);
        model.addAttribute("finalanswers", finalanswers);
        model.addAttribute("username", username);
        String result = resultsCalculate.calculate(finalanswers,answerdataService);
        model.addAttribute("personality", result);
        return "result";
    }

    @PostMapping("ig")
    public String createUser(@RequestParam String finalanswers, @RequestParam String personality, @RequestParam String username, @RequestParam String ig, Model model) {
        //check if already exists and assing true or false to existingUser attribute:
         model.addAttribute("existingUser",userService.userExistsByInstagramId(ig));
        //save user, and show other similar users
        User user = new User();
        user.setR_B(personality);
        model.addAttribute("personality", personality);
        user.setName(username);
        user.setAnswers(finalanswers);
        user.setDt(LocalDateTime.now());
        user.setInstragramID(ig);
        user.setLocation("example");
        userService.saveUser(user);
        List<User> users = userService.getRandomUsers(user.getR_B());
        model.addAttribute("users", users);
        return "result";
        }
    }


