package com.dpd.exercise.entity;

import com.dpd.exercise.entity.Address;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Entity
@Transactional
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "per_id")
    private Long per_id;
    private String name;
    private String birthplace;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;
    private String mothername;
    @Column(unique = true)
    private String taj;
    @Column(unique = true)
    private String aaj;
    @Column(unique = true)
    private String email;



    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_per_id", referencedColumnName = "per_id")
    private List<Address> address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_per_id", referencedColumnName = "per_id")
    private List<Telephone> telephone;
}
