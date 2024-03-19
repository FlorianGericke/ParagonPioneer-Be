package com.example.paragonPioneerBackend.Bin.Security.Requests;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
public class AuthenticationRequest {
    String email;
    String password;
}
