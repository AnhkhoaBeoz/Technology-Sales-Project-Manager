package com.kb.quanlysanpham.service;

import com.kb.quanlysanpham.modal.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    List<String> getAllRoleName();
    Role findRoleById(Long id);
    List<Role> findAll();

    Role findRoleByName(String name);

    void saveRole(Role role);

    void deleteRole(Long id);
}
