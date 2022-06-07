package com.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "classes", schema = "learner_academy")
public class ClassesEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "teacher")
    private int teacher_id;

    @Basic
    @Column(name = "subject")
    private int subject_id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "teacher", insertable = false, updatable = false, nullable = false)
    private TeachersEntity teacher;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "subject", insertable = false, updatable = false, nullable = false)
    private SubjectsEntity subject;

    @OneToMany(mappedBy = "course")
    private Set<StudentsEntity> students;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getTeacher_id() {
        return teacher_id;
    }
    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getSubject_id() {
        return subject_id;
    }
    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public SubjectsEntity getSubject() {
        return subject;
    }
    public void setSubject(SubjectsEntity subject) {
        this.subject = subject;
    }

    public TeachersEntity getTeacher() {
        return teacher;
    }
    public void setTeacher(TeachersEntity teacher) {
        this.teacher = teacher;
    }

    public Set<StudentsEntity> getStudents() { return students; }
    public void setStudents(Set<StudentsEntity> students) { this.students = students; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassesEntity that = (ClassesEntity) o;
        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return true;
    }

    @Override
    public String toString() {
        return "ClassesEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacher=" + (this.teacher == null ? this.teacher_id : teacher) +
                ", subject=" + (this.subject == null ? this.subject_id : subject) +
                '}';
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
