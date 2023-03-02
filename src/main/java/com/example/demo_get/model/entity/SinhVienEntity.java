package com.example.demo_get.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SINHVIEN")
public class SinhVienEntity {
    @Id
    @Column(name = "USERID")
    private Integer Id;
    @Column(name = "NAMEUSER")
    private String nameUser;
    @Column(name = "AGE")
    private Integer age;
}
