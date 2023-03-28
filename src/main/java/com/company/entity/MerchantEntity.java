package com.company.entity;

import com.company.enums.MerchantStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "merchant")
public class MerchantEntity extends BaseEntity{

    @Column(name = "card_number")
    String cardNumber;
    @Column
    @Enumerated(EnumType.STRING)
    private MerchantStatus status;
}
