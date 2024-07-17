package com.sr.redbluepersonalitytest.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

     @Autowired
    private EntityManager entityManager;
    
    public List<User> getRandomUsers(String color) {
        String baseQuery = "SELECT * FROM menagerie.user WHERE R_B = :color ORDER BY RAND() LIMIT 5";
        Query query = entityManager.createNativeQuery(baseQuery, User.class);
        query.setParameter("color", color);
        return query.getResultList();
    }

    public boolean userExistsByInstagramId(String instagramId) {
        String queryString = "SELECT COUNT(*) FROM menagerie.user WHERE instragramid = LOWER(:instagramId)";
        Query query = entityManager.createNativeQuery(queryString);
        query.setParameter("instagramId", instagramId);
        Long count = (Long) query.getSingleResult();
        return count > 0;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}