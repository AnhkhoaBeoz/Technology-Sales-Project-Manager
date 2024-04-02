package com.kb.quanlysanpham.controller;

import com.kb.quanlysanpham.modal.Role;
import com.kb.quanlysanpham.service.RoleService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("admin/role")
public class RoleController {
    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public String showRole(Model model) {
        List<Role> roles = roleService.findAll();

        model.addAttribute("roles", roles);
        return "role";
    }

    @GetMapping("/add")
    public String addRole(Model model) {
        Role role = new Role();
        model.addAttribute("role", role);
        return "role-add";
    }

    @GetMapping("/edit/{id}")
    public String editRole(@PathVariable("id") Long id, Model model) {
        Role role = roleService.findRoleById(id);
        model.addAttribute("role", role);
        return "role-add";
    }

    @PostMapping("/save")
    public String saveRole(@Valid @ModelAttribute("role") Role role, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "role-add";
        }
        if (role.getId() == null) {
            roleService.saveRole(role);
        } else {
            Role role1 = roleService.findRoleById(role.getId());
            role1.setName(role.getName());
            roleService.saveRole(role1);

        }
        redirectAttributes.addFlashAttribute("message", "Role saved successfully!");
        return "redirect:/role";
    }

    @GetMapping("/delete/{id}")
    public String deleteRole(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        roleService.deleteRole(id);
        redirectAttributes.addFlashAttribute("message", "Role deleted successfully!");
        return "redirect:/role";
    }
}
