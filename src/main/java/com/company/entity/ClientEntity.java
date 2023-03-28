package com.company.entity;

import com.company.enums.ClientStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "client")
public class ClientEntity extends BaseEntity{

    @Column
    private String surname;
    @Column(nullable = false, unique = true)
    private String phone;
    @Column(nullable = false)
    private String password;
    @Column
    @Enumerated(EnumType.STRING)
    private ClientStatus status;
}
