package com.example.paragonPioneerBackend.Bin.Security.Responses;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
public class AuthenticationResponse {
    private String token;
}
