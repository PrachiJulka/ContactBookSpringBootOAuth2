package com.contact.contactBook.services;

import com.contact.contactBook.dao.UserRepository;
import com.contact.contactBook.domain.User;
import com.contact.contactBook.dto.requestDtos.RegistrationRequestDto;
import com.contact.contactBook.dto.responseDtos.SuccessResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(RegistrationRequestDto registrationRequestDto) {
        User user = null;
        user = userRepository.findByEmail(registrationRequestDto.getEmail());
        if (user == null) {
            user.setFirstName(registrationRequestDto.getFirstName());
            user.setLastName(registrationRequestDto.getLastName());
            user.setEmail(registrationRequestDto.getEmail());
            userRepository.save(user);
        }
        return user;

    }
}
