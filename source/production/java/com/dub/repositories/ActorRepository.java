package com.dub.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dub.entities.Actor;

public interface ActorRepository extends CrudRepository<Actor, Long>
{
	List<Actor> findByFirstNameAndLastName(String firstName, String lastName);
}
