package com.enigma.ToDo.entity;

import com.enigma.ToDo.constant.UserRole;
import com.enigma.ToDo.constant.Constant;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = Constant.table_user)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name="username", nullable=false)
    private String username;

    @Column(name="email", nullable=false)
    private String email;

    @Column(name="password", nullable=false)
    private String password;

    @Column(name="role", nullable=false)
    private UserRole role;
}
