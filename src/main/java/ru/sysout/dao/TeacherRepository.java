package ru.sysout.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sysout.model.Teacher;

/**
 * @author Nazarov Ivan
 * @date 12/16/2022
 */
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
