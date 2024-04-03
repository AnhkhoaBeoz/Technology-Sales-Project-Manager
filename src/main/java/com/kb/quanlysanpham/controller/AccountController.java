package com.kb.quanlysanpham.controller;

import com.kb.quanlysanpham.modal.Account;
import com.kb.quanlysanpham.payload.CreateAccountDTO;
import com.kb.quanlysanpham.payload.RegisterRequestDTO;
import com.kb.quanlysanpham.service.AccountService;
import com.kb.quanlysanpham.service.RoleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/accounts")
public class AccountController {
    private AccountService accountService;
    private RoleService roleService;

    private PasswordEncoder passwordEncoder;

    public AccountController(AccountService accountService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.accountService = accountService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping
    public String showTableAccount(Model model) {
        List<Account> accounts = accountService.findAll();
        model.addAttribute("accounts", accounts);
        return "account";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createAccount(Model model) {
        model.addAttribute("newAccount", new Account());
        model.addAttribute("roles", roleService.findAll());
        return "createAccount";
    }

    @GetMapping("/edit/{id}")
    public String showEditAccountForm(Model model, @PathVariable Long id) {
        Account account = accountService.findById(id);
        model.addAttribute("newAccount", account);
        model.addAttribute("roles", roleService.findAll());
        return "createAccount";
    }

    @PostMapping("/save")
    public String saveAccount(@ModelAttribute("newAccount") @Valid Account account, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "createAccount";
        }
        if (account.getId() == null) {
            account.setPassword(passwordEncoder.encode(account.getPassword()));
        }
        accountService.saveOrUpdate(account);
        redirectAttributes.addFlashAttribute("message", "Thao tác thành công");
        return "redirect:/admin/accounts"; // Chuyển hướng về trang danh sách tài khoản sau khi lưu thành công
    }


    @GetMapping("/delete/{id}")
    public String deleteAccount(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        accountService.deleteAccount(id);
        redirectAttributes.addFlashAttribute("message", "Xóa tài khoản thành công");
        return "redirect:/admin/accounts";
    }
}
