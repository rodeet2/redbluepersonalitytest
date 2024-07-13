
package com.sr.redbluepersonalitytest.result;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class answerdataService {

    private final answermap_Repository ansRepo;

    public answerdataService(answermap_Repository ansRepo) {
        this.ansRepo = ansRepo;
    }

    public List<answermap> getAllaAnswers() {
        return ansRepo.findAll();
    }

    public Optional<answermap> getAnswerByID(String id) {
        return ansRepo.findById(id);
    }


    public answermap saveAnswer(answermap answer) {
        return ansRepo.save(answer);
    }
}