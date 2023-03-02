package com.example.demo_get.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class sinhVienDto {
    private Integer Id;
    private String nameUser;
    private Integer age;
    public  sinhVienDto (Integer id, String nameUser, Integer age){
        this.Id = id;
        this.nameUser = nameUser;
        this.age = age;
    }

}
