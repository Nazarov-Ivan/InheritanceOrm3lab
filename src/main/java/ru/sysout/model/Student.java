package ru.sysout.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Student extends Person {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

}