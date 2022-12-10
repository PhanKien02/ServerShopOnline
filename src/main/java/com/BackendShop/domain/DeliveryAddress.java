package com.BackendShop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "delivery_address")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryAddress {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "orderer_name")
    private String ordererName;

    @Column(name = "phone_orderer")
    private String phoneOderer;

    @Column(name = "default_address")
    private Boolean defaultAddress;

    @Column(name = "detail_address")
    private String DetailAddress;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

}
