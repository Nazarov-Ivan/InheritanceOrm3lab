package ru.sysout.model;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "groups")
@OptimisticLocking(type = OptimisticLockType.DIRTY)
@DynamicUpdate
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "number", nullable = false)
    private String number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }

    @Version
    @Column(name = "version")
    @Type(type = "dbtimestamp")
    private Timestamp version;

    public Timestamp getVersion() {
        return version;
    }

    public void setVersion(Timestamp version) {
        this.version = version;
    }
}