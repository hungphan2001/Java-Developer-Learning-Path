package com.example.usermanagement.controller;

import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.entity.Users;
import com.example.usermanagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/index")
    public String home(){
        return "index";
    }

    @GetMapping("/signup")
    public String showRegistractionForm(Model theModel){
        UserDto user = new UserDto();
        theModel.addAttribute("user",user);
        return "signup";
    }

    @PostMapping("/signup/save")
    public String signup(@Valid @ModelAttribute("user") UserDto userDto,
                         BindingResult theResult,
                         Model theModel){
        Users existingUser = userService.findUserByEmail(userDto.getEmail());
        if(existingUser != null && existingUser.getEmail()!= null && !existingUser.getEmail().isEmpty()){
            theResult.rejectValue("email",null,
                    "There is already an acc signed with the same email");
        }
        if(theResult.hasErrors()){
            theModel.addAttribute("user",userDto);
            return "/signup";
        }
         userService.saveUser(userDto);
         return "redirect:/signup?success";
    }
}
