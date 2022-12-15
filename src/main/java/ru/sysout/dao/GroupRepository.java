package ru.sysout.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import ru.sysout.model.Group;

import javax.persistence.LockModeType;
import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Integer> {
    Group findByNumber (String name);

    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    Optional<Group> findWithLockingByNumber (String number);
}