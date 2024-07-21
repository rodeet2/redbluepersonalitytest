package com.sr.redbluepersonalitytest.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
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
    
    public List<User> getRandomUsers(String color, String instagramId) {
        String baseQuery = "SELECT * FROM menagerie.user WHERE R_B = :color AND instragramid NOT LIKE LOWER(:instagramId) ORDER BY RAND() LIMIT 5";
        Query query = entityManager.createNativeQuery(baseQuery, User.class);
        query.setParameter("color", color);
        query.setParameter("instagramId", instagramId);
        return query.getResultList();
    }

    public boolean userExistsByInstagramId(String instagramId) {
        String queryString = "SELECT COUNT(*) FROM menagerie.user WHERE instragramid = LOWER(:instagramId)";
        Query query = entityManager.createNativeQuery(queryString);
        query.setParameter("instagramId", instagramId);
        Long count = (Long) query.getSingleResult();
        return count > 0;
    }

    public boolean checkifDateMatch(String Date, String instagramId) {
        String queryString = "SELECT COUNT(*) FROM menagerie.user WHERE DATE(dt) = :Date AND instragramid = LOWER(:instagramId)";
        Query query = entityManager.createNativeQuery(queryString);
        query.setParameter("instagramId", instagramId);
        query.setParameter("Date", Date);
        Long count = (Long) query.getSingleResult();
        return count > 0;
    }
    @Transactional
    public boolean deleteUser(String instagramId) {
        String queryString = "DELETE FROM menagerie.user WHERE instragramid = LOWER(:instagramId)";
        Query query = entityManager.createNativeQuery(queryString);
        query.setParameter("instagramId", instagramId);
        int rowsAffected = entityManager.createNativeQuery(queryString)
        .setParameter("instagramId", instagramId)
        .executeUpdate();
return rowsAffected > 0;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}