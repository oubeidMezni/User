package tn.esprit.backend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.backend.entities.User;

import java.util.Optional;

@Repository
public interface UserRespository extends JpaRepository<User,Long> {

    Optional<User> findByLogin(String login);
}
