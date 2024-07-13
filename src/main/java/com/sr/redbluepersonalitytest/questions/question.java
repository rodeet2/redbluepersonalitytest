package com.sr.redbluepersonalitytest.questions;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class question {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer ID;
    String name;
    String answers;
    String answerCodes;

    public question(){
    }

}
