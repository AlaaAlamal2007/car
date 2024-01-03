package com.example.alaa.car.controller;

import com.example.alaa.car.domain.Address;
import com.example.alaa.car.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/address")
@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;
    @GetMapping("/{id}")
    public Address getOne(@PathVariable Long id){
        return addressService.getOne(id);
    }
}
