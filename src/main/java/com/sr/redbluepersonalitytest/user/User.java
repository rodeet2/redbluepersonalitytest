package com.sr.redbluepersonalitytest.user;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String R_B;
    private String answers = "";
    private String instragramID;
    private String location;
    private LocalDateTime dt;
    
    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getR_B() {
        return R_B;
    }
    public void setR_B(String r_B) {
        R_B = r_B;
    }
    public String getInstragramID() {
        return instragramID;
    }
    public void setInstragramID(String instragramID) {
        this.instragramID = instragramID;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public LocalDateTime getDt() {
        return dt;
    }
    public void setDt(LocalDateTime localDateTime) {
        this.dt = localDateTime;
    }

    public String get_answers(){
        return answers;
    }

    }