package project.duan.qlybancafe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.duan.qlybancafe.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    boolean existsByUsername(String username);

    Optional<Account> findByUsername(String username);
}
