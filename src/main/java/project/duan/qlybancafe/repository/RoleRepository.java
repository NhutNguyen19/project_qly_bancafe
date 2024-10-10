package project.duan.qlybancafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.duan.qlybancafe.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {}
