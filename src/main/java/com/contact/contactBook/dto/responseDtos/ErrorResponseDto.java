package com.contact.contactBook.dto.responseDtos;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ErrorResponseDto {
    private List<String> msg = new ArrayList<>();
    private boolean status = false;
}
