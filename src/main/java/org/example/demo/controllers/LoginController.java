package org.example.demo.controllers;

import org.example.demo.models.User;
import org.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        User user = userService.findByUsernameAndPassword(username, password);
        if (user != null) {
            return "redirect:/"; // Przekierowanie do strony głównej po pomyślnym logowaniu
        } else {
            model.addAttribute("loginError", "Nieprawidłowa nazwa użytkownika lub hasło.");
            return "login"; // Powrót do formularza logowania z komunikatem o błędzie
        }
    }
}
