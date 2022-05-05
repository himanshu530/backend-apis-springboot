package com.blog.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class UserDTO {

    private int id;

    @NotEmpty
    private String name;
    @Email
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String about;


}
