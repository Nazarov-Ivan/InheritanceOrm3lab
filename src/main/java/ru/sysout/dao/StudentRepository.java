package ru.sysout.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sysout.model.Student;

/**
 * @author Nazarov Ivan
 * @date 12/16/2022
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
