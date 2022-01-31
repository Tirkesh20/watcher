package by.idFinanceLab.watcher.repository;

import by.idFinanceLab.watcher.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findUsersByCoin(String coin);
}
