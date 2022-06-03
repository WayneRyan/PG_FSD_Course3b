package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "classes", schema = "learner_academy")
public class ClassesEntity {
    private int id;
    private String name;
    private Integer subject;
    private Integer teacher;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "subject")
    public Integer getSubject() {
        return subject;
    }

    public void setSubject(Integer subject) {
        this.subject = subject;
    }

    @Basic
    @Column(name = "teacher")
    public Integer getTeacher() {
        return teacher;
    }

    public void setTeacher(Integer teacher) {
        this.teacher = teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassesEntity that = (ClassesEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (subject != null ? !subject.equals(that.subject) : that.subject != null) return false;
        if (teacher != null ? !teacher.equals(that.teacher) : that.teacher != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "ClassesEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject=" + subject +
                ", teacher=" + teacher +
                '}';
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        return result;
    }
}
