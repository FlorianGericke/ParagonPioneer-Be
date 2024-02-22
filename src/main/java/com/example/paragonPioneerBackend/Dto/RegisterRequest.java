package com.example.paragonPioneerBackend.Dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
public class RegisterRequest {
    private String email;
    private String password;
}
