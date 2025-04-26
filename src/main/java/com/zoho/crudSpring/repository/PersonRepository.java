package com.zoho.crudSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zoho.crudSpring.dto.Person;

public interface PersonRepository  extends JpaRepository<Person, Integer>{

}
