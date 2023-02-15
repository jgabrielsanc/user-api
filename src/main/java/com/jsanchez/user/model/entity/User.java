package com.jsanchez.user.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "token",nullable = false)
    private String token;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user", fetch = FetchType.LAZY)
    private List<Phone> phones;

    @Column(name = "created",nullable = false)
    private Date created;

    @Column(name = "modified",nullable = false)
    private Date modified;

    @Column(name = "last_login",nullable = false)
    private Date lastLogin;

    @Column(name = "is_active",nullable = false)
    private Boolean isActive;


    public void setDefaultInitialData(Date date) {
        this.isActive = true;
        this.created = date;
        this.modified = date;
        this.lastLogin = date;
    }
}
