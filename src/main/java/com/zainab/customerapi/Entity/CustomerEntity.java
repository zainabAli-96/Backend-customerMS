package com.zainab.customerapi.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", unique = true, updatable = false)
    private long id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private String address;
    private Date birth_date;
    private Timestamp registeredOn;
}
