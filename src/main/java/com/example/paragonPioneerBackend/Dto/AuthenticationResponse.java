package com.example.paragonPioneerBackend.Dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
public class AuthenticationResponse {
    private String token;
}
