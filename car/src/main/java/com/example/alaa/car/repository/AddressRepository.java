package com.example.alaa.car.repository;

import com.example.alaa.car.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


    @Repository
    public interface AddressRepository extends JpaRepository<Address,Long>{



    }

