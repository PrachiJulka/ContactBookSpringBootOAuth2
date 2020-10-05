package com.contact.contactBook.controllers;

import com.contact.contactBook.domain.User;
import com.contact.contactBook.dto.requestDtos.RegistrationRequestDto;
import com.contact.contactBook.dto.responseDtos.ErrorResponseDto;
import com.contact.contactBook.dto.responseDtos.SuccessResponseDto;
import com.contact.contactBook.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/public")
    public String publico() {
        return "Public Pages";
    }

    @RequestMapping("/private")
    public String private1()
    {
        return "Private Page";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "Administrator Page";
    }

    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody RegistrationRequestDto registrationRequestDto){
        ErrorResponseDto errorResponseDto=new ErrorResponseDto();
        try {
            User user = userService.createUser(registrationRequestDto);
            if(user!=null){
            errorResponseDto.getMsg().add("User created Successfully");
            }
            else{
                errorResponseDto.getMsg().add("Some Error Occured");
            }
        }
        catch (Exception e){
            errorResponseDto.getMsg().add(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponseDto);
        }
        return ResponseEntity.ok().body(errorResponseDto);
    }

}
