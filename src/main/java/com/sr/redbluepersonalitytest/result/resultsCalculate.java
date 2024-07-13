package com.sr.redbluepersonalitytest.result;

public class resultsCalculate {


    public static String calculate(String answers, answerdataService answerdataService){
        Integer redpoints = 0;
        Integer bluepoints = 0;
        String[] userAnswers = ((answers)).split(",");

        for(String ans : userAnswers){
            if((answerdataService.getAnswerByID(ans)).get().getR_B().equalsIgnoreCase("RED")){redpoints++;}else{bluepoints++;}
        }
    
        if(redpoints > bluepoints){
            return "Red";
        }else{
            return "Blue";
        }

    }

}
