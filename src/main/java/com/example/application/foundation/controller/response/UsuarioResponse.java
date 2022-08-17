package com.example.application.foundation.controller.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@Builder
public class UsuarioResponse {
    private Long id;
}


