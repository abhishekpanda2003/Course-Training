package com.example.Library.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString(exclude = "password")
public class MemberReqDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotNull
    private LocalDate membershipDate;

    @NotNull
    private Boolean active;

}
