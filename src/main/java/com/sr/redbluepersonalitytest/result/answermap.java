package com.sr.redbluepersonalitytest.result;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class answermap {

    @Id
    private String IDcode;
    private String answer_choice;
    private String R_B;
    private String Question;
    private Integer points;

    public answermap(){
        
    }
    public answermap(String id, String ans, String RB, String Ques, Integer point){
        this.IDcode = id;
        this.answer_choice = ans;
        this.R_B = RB;
        this.Question = Ques;
        this.points = point;
    }

    public String getIDcode() {
        return IDcode;
    }
    public void setIDcode(String iDcode) {
        IDcode = iDcode;
    }
    public String getAnswer() {
        return answer_choice;
    }
    public void setAnswer(String answer) {
        this.answer_choice = answer;
    }
    public String getR_B() {
        return R_B;
    }
    public void setR_B(String r_B) {
        R_B = r_B;
    }
    public String getQuestion() {
        return Question;
    }
    public void setQuestion(String question) {
        Question = question;
    }
    public Integer getPoints() {
        return points;
    }
    public void setPoints(Integer points) {
        this.points = points;
    }

}
