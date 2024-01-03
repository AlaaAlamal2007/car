package com.example.alaa.car.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
//    @JoinTable(
//            name="teacher_subject",
//            joinColumns={@JoinColumn(name="teacher_id")},
//
//            inverseJoinColumns={@JoinColumn(name="subject_id")}
//    )
//    private List<Subject> subjectList;

    @JoinTable(name = "teacher_subject",
            joinColumns = {@JoinColumn(name = "teacher_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "subject_id",referencedColumnName = "id")})
    private Set<Subject> subjectList = new HashSet<>();

    public Teacher() {
    }

//    public Teacher(String name, List<Subject> subjectList) {
//        this.name = name;
//        this.subjectList = subjectList;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(Set<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +

                '}';
    }

    public void assignSubjectToTeacher(Subject subject) {
        subjectList.add(subject);

    }

    public void deleteAssignSubjectToTeacher(Subject subject) {
        subjectList.remove(subject);
    }


    public void addSubject(Subject subject) {
        this.subjectList.add(subject);
        subject.getTeacherList().add(this);
    }



    public void removeSubject(long subjectId) {
        Subject subject = this.subjectList.stream().filter(sub -> sub.getId() == subjectId).findFirst().orElse(null);
        if (subject != null) {
            this.subjectList.remove(subject);
            subject.getTeacherList().remove(this);
        }
    }
}
