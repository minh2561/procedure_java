package com.example.demo_get.service;

import com.example.demo_get.model.dto.sinhVienDto;
import com.example.demo_get.model.entity.SinhVienEntity;
import com.example.demo_get.model.in.sinhVienIn;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface sinhVienService {
    List<sinhVienDto> getAll();

    Map<String, Object> create(sinhVienIn sinhVienIn);

    Map<String, Object> delete(Integer Id);//Map chuyen ve message key:value;

    Map<String, Object> update(Integer Id, sinhVienIn sinhVienIn);

    Map<String, Object> getById(String Id);

    List<sinhVienDto> getPaginate(sinhVienIn sinhVienIn);
}
