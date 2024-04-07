package com.example.paragonPioneerBackend.Bin.Security.Requests;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest {
    String email;
    String password;
}
