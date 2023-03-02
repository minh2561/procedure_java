package com.example.demo_get.mapper;

import com.example.demo_get.model.dto.sinhVienDto;
import com.example.demo_get.model.entity.SinhVienEntity;
import com.example.demo_get.model.in.sinhVienIn;

public class sinhVienMapper {
    // in -> entity
    public static SinhVienEntity map(sinhVienIn sinhvienIn) {
        SinhVienEntity sinhvienEntity = new SinhVienEntity();
        sinhvienEntity.setId(sinhvienIn.getId());
        sinhvienEntity.setAge(sinhvienIn.getAge());
        sinhvienEntity.setNameUser(sinhvienIn.getNameUser());
        return sinhvienEntity;
    }

    //entity -> dto
    public static sinhVienDto map1(SinhVienEntity sinhvienEntity) {
        sinhVienDto sinhvienDto = new sinhVienDto();
        sinhvienDto.setId(sinhvienEntity.getId());
        sinhvienDto.setAge(sinhvienEntity.getAge());
        sinhvienDto.setNameUser(sinhvienEntity.getNameUser());
        return sinhvienDto;
    }
}
