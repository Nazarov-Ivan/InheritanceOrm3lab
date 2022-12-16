package ru.sysout.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.sysout.model.Person;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}