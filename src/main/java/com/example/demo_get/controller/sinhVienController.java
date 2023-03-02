package com.example.demo_get.controller;

import com.example.demo_get.model.in.sinhVienIn;
import com.example.demo_get.service.sinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class sinhVienController {
    @Autowired
    // goi phuong thuc

    private sinhVienService sinhVienService;


    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(sinhVienService.getAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody sinhVienIn sinhvienIn) {
        return new ResponseEntity<>(sinhVienService.create(sinhvienIn), HttpStatus.CREATED);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<?> delete(@PathVariable Integer Id) {
        return new ResponseEntity<>(sinhVienService.delete(Id), HttpStatus.OK);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<?> update(@PathVariable Integer Id, @RequestBody sinhVienIn sinhvienIn) {
        return new ResponseEntity<>(sinhVienService.update(Id, sinhvienIn), HttpStatus.OK);
    }


    @PostMapping ("/minh/{Id}")
    public ResponseEntity<?> getById(@PathVariable String Id) {
        return new ResponseEntity<>(sinhVienService.getById(Id), HttpStatus.OK);
    }


    @PostMapping("/paginate")
    public ResponseEntity<?> getPaginate(@RequestBody sinhVienIn sinhVienIn){
        return new ResponseEntity<>(sinhVienService.getPaginate(sinhVienIn),HttpStatus.OK);
    }
}

