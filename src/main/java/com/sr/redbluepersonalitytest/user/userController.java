package com.sr.redbluepersonalitytest.user;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class userController {

		@PostMapping("/start")
        public String start(Model model, @RequestParam String username) {
        model.addAttribute("username", username);
        return "forward:/q/1";
    }
    
}
