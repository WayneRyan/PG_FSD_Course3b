package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "students_classes", schema = "learner_academy")
public class StudentsClasses_entity {
    private int student;
    private int clazz;
    private int id;

    @Basic
    @Column(name = "student")
    public int getStudent() {
        return student;
    }

    public void setStudent(int student) {
        this.student = student;
    }

    @Basic
    @Column(name = "class")
    public int getClazz() {
        return clazz;
    }

    public void setClazz(int clazz) {
        this.clazz = clazz;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentsClasses_entity that = (StudentsClasses_entity) o;

        if (student != that.student) return false;
        if (clazz != that.clazz) return false;
        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = student;
        result = 31 * result + clazz;
        result = 31 * result + id;
        return result;
    }
}
