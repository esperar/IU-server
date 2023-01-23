package com.IU.domain.user.entity;

import com.IU.domain.user.entity.enum_type.Authority;
import lombok.*;

import javax.persistence.*;

@Getter @Builder @Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "authority")
    private Authority authority;

}
