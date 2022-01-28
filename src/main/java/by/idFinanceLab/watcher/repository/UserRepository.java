package by.idFinanceLab.watcher.repository;

import by.idFinanceLab.watcher.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findUserByCoin(String coin);
}
