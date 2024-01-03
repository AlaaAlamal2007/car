package com.example.alaa.car.repository;

import com.example.alaa.car.domain.Subject;
import com.example.alaa.car.domain.Teacher;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    @Query("From Subject where student.id=:studentId")
    List<Subject> getByStudentId(Long studentId);

    List<Subject> findSubjectListByTeacherListId(Long teacherId);

    @Modifying
    @Transactional
    @Query("Update Student student set student=null where id=:subjectId")
    void updateSubjectStudent(Long subjectId);

    @Query("From Subject where student.id=:studentId")
    Set<Subject> getAllSubjectForStudent(Long studentId);

    @Transactional

    void  deleteAllByStudentId(Long studentId);
}
