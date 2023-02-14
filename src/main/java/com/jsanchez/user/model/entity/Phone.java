package com.jsanchez.user.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "phone")
public class Phone implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phone_generator")
    @SequenceGenerator(name="phone_generator", sequenceName = "phone_seq", allocationSize=1)
    private Long id;

    @Column(name = "number",nullable = false)
    private String number;

    @Column(name = "city_code",nullable = false)
    private String cityCode;

    @Column(name = "contry_code",nullable = false)
    private String contryCode;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

}
