package com.sr.redbluepersonalitytest.questions;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class questionsController {

	@Autowired
    private questionService questionsService;

	List<question> q;

      @PostMapping("/q/1")
	  public String load_question_page(Model model, @RequestParam (required = false) String username){
		this.q= questionsService.getAllQuestions();
		model.addAttribute("question", q.get(0).name);
		model.addAttribute("options", q.get(0).answers.split(","));
		model.addAttribute("answerCodes", q.get(0).answerCodes.split(","));
		model.addAttribute("questionID", q.get(0).ID);
		model.addAttribute("initialAnswer", "");
		model.addAttribute("username", username);
		return "questions_page";
	  }
	
    @PostMapping("/submitChoice")
    public String submitChoice(@RequestParam String selectedOption, @RequestParam Integer questionId, @RequestParam String initialAnswer, @RequestParam String username, Model model) {
		Integer nextQuestionId = (questionId-1) + 1;
		if(nextQuestionId > q.size() -1){
			return "forward:/results";
		}
		model.addAttribute("question", q.get(nextQuestionId).name);
		model.addAttribute("options", q.get(nextQuestionId).answers.split(","));
		model.addAttribute("answerCodes", q.get(nextQuestionId).answerCodes.split(","));
		model.addAttribute("questionID", q.get(nextQuestionId).ID);
		model.addAttribute("initialAnswer", initialAnswer + ","+ selectedOption);
		model.addAttribute("username", username);
        return "questions_page";
    }

    
}
