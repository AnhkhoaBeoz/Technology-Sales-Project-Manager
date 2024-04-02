package com.kb.quanlysanpham.service.Impl;

import com.kb.quanlysanpham.modal.Role;
import com.kb.quanlysanpham.repository.RoleRepository;
import com.kb.quanlysanpham.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        return this.roleRepository.findAll();
    }

    @Override
    public List<String> getAllRoleName() {
        return this.roleRepository.getAllRoleName();
    }

    @Override
    public Role findRoleById(Long id) {
        return this.roleRepository.findRoleById(id);

    }

    @Override
    public Role findRoleByName(String name) {
        return this.roleRepository.findRoleByName(name);
    }

    @Override
    public void saveRole(Role role) {
        this.roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long id) {
        this.roleRepository.deleteById(id);
    }
}
