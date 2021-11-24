package com.example.springsecurityjwtjpa.user;

import lombok.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginRequestDTO {

    @NotBlank(message = "User Name must not be empty")
    private String userName;

    @NotBlank(message = "Password must not be empty")
    private String password;
}
