package com.example.springboot.database.dao;

import com.example.springboot.database.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;


public interface OfficeDAO extends JpaRepository<Office, Long> {

    List<Office> findAll();

    Office findById(Integer id);

    //List<Office> findByCity(String city);

    //List<Office> findByState(String state);

    //List<Office> findByCountry(String country);

    //List<Office> findByCityandStateAndCountry(String city, String state, String country);

    //List<Office> findByPostalCode(String postalCode);
}