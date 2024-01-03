package com.example.alaa.car.service;

import com.example.alaa.car.domain.Address;
import com.example.alaa.car.domain.Student;
import com.example.alaa.car.repository.AddressRepository;
import com.example.alaa.car.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.stereotype.Service;



@Service
public class AddressService  {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private StudentRepository studentRepository;

    public Address getOne(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("address id does not exist"));

        return address;
    }

}
