package com.kb.quanlysanpham.repository;

import com.kb.quanlysanpham.modal.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query(value = "SELECT r.name FROM Role r", nativeQuery = true)
    List<String> getAllRoleName();
    List<Role> findAll();

    Role findRoleById(Long id);
    Role findRoleByName(String name);

    void deleteById(Long id);

}
