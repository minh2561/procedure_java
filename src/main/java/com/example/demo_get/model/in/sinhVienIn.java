package com.example.demo_get.model.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class sinhVienIn {
    private Integer Id;
    private String nameUser;
    private Integer age;
    private Integer activePage;
    private Integer limit;
}
