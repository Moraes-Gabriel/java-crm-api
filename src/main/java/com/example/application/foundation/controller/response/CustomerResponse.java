package com.example.application.foundation.controller.response;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CustomerResponse {

    @NotNull
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private String company;
}
