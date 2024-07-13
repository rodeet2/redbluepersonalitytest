package com.sr.redbluepersonalitytest.questions;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class questionService {

    @Autowired
    private final question_Repository quesRepo;    

    List<question> questionslist; 

    public questionService(question_Repository quesRepo){

    this.quesRepo = quesRepo;

    // Integer Number1;
    // String Name1;
    // String[] ansfor1;

    // Integer Number2;
    // String Name2;
    // String[] ansfor2;

    // Integer Number3;
    // String Name3;
    // String[] ansfor3;

    //goose or moose

    // Number1 = 1;
	// Name1 = "Pineapple Pizza?";
	// ansfor1= new String[] {"Yes", "No"};

	// Number2 = 2;
	// Name2 = "Anime?";
	// ansfor2= new String[] {"A lot", "Not a lot"};

	// Number3 = 3;
	// Name3 = "Favorite House Animal";
	// ansfor3= new String[] {"Dog", "Cat"};

    }

    public question getQuestion(Integer ID) {
     return questionslist.get(ID-1);
    }

    public List<question> getAllQuestions() {
        return quesRepo.findAll();
    }

    public question saveQuestion(question q) {
        return quesRepo.save(q);
    }

    
}