package com.example.paragonPioneerBackend.Bin.Security.Requests;

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
