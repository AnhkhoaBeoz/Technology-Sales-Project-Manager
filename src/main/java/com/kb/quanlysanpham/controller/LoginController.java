package com.kb.quanlysanpham.controller;

import com.kb.quanlysanpham.Constants.AppConstant;
import com.kb.quanlysanpham.modal.Account;

import com.kb.quanlysanpham.modal.Role;
import com.kb.quanlysanpham.payload.LoginRequestDTO;
import com.kb.quanlysanpham.payload.RegisterRequestDTO;
import com.kb.quanlysanpham.service.AccountService;
import com.kb.quanlysanpham.service.LoginService;
import com.kb.quanlysanpham.service.RoleService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collections;


@Controller
@RequestMapping("/auth")
public class LoginController {
    private AccountService accountService;
    private LoginService loginService;
    private AuthenticationManager authenticationManager;


    public LoginController(AccountService accountService, LoginService loginService, AuthenticationManager authenticationManager) {
        this.accountService = accountService;
        this.loginService = loginService;
        this.authenticationManager = authenticationManager;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLoginForm() {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("loginRequestDTO", new LoginRequestDTO());
        return modelAndView;
    }


//    @PostMapping("/confirmLogin")
//    public String confirmLogin(@Valid @ModelAttribute("loginRequestDTO") LoginRequestDTO loginRequestDTO,
//                               BindingResult bindingResult,
//                               RedirectAttributes redirectAttributes) {
//
//        if (bindingResult.hasErrors()) {
//            return "login";
//        }
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword())
//        );
//        if (!authentication.isAuthenticated()) {
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            return "redirect:/index";
//        }
//        return "redirect:/auth/login";
//    }


    @GetMapping("/register")
    public ModelAndView showRegisterForm(Model model) {
        RegisterRequestDTO newAccount = new RegisterRequestDTO();
        model.addAttribute("registerRequestDTO", newAccount);
        return new ModelAndView("register");
    }

    @PostMapping("/process_register")
    public String processRegister(@Valid @ModelAttribute("registerRequestDTO") RegisterRequestDTO registerRequestDTO,
                                  BindingResult bindingResult
            , RedirectAttributes redirectAttributes) {
        Account accountExistsWithEmail = accountService.findAccountByEmail(registerRequestDTO.getEmail());
        Account accountExistsWithUsername = accountService.findAccountByUsername(registerRequestDTO.getUsername());
        if (accountExistsWithEmail != null) {
            bindingResult.rejectValue("email", "error.user", AppConstant.MESSAGE_EMAIL_EXISTS);
        }
        if (accountExistsWithUsername != null) {
            bindingResult.rejectValue("username", "error.user", AppConstant.MESSAGE_USERNAME_EXISTS);
        }
        if (!registerRequestDTO.getPassword().equals(registerRequestDTO.getConfirmPassword())) {
            bindingResult.rejectValue("confirmPassword", "error.user", AppConstant.MESSAGE_PASSWORD_NOT_MATCH);
        }
        if (bindingResult.hasErrors()) {
            return "register";
        }

        this.loginService.register(registerRequestDTO.getUsername(),
                registerRequestDTO.getEmail(),
                registerRequestDTO.getPassword(),
                registerRequestDTO.getConfirmPassword(),
                registerRequestDTO.getFullName(),
                registerRequestDTO.getAddress(),
                registerRequestDTO.getPhone());
        redirectAttributes.addFlashAttribute("successMessage", AppConstant.MESSAGE_REGISTER_SUCCESS);
        return "redirect:/auth/login";
    }
}
