package com.sr.redbluepersonalitytest.questions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface question_Repository extends JpaRepository<question, Integer> {
    
}