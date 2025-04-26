package com.zoho.crudSpring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zoho.crudSpring.dto.Person;
import com.zoho.crudSpring.repository.PersonRepository;


//------------------CONNECT SPRING BOOT TO REACT.JS----------------------------------

@RestController
@CrossOrigin
public class MyController {
	
	@Autowired
	PersonRepository personRepository;
	
	@PostMapping("/persons")
	public String insert(@RequestBody Person person)
	{
		personRepository.save(person);
		return "data inserted";
	}
	
	@GetMapping("/persons/{id}")
	public Optional<Person> find(@PathVariable int id)
	{
     return personRepository.findById(id);
		
	}
	
	@DeleteMapping("/persons/{id}")
	public String delete(@PathVariable int id)
	{
		personRepository.deleteById(id);
		return "data deleted";
	}
	
	@GetMapping("/persons")
	public List<Person> findAll()
	{
		return personRepository.findAll();
	}

	@DeleteMapping("/persons")
  public String deleteAll()
  {
	  personRepository.deleteAll();
	  return "All data Deleted";
  }
	
	@PutMapping("persons/{id}")
	public String update(@PathVariable int id,@RequestBody Person person)
	{
		Optional<Person> optional=personRepository.findById(id);
		if(optional.isPresent())
		{
			Person p1=optional.get();
			p1.setName(person.getName());
			p1.setAddress(person.getAddress());
			p1.setEmail(person.getEmail());
			p1.setPassword(person.getPassword());
			personRepository.save(p1);
			return "Data Updated Successfully";
		}
		else {
			return "No Data Found";
		}
	}
	
}
