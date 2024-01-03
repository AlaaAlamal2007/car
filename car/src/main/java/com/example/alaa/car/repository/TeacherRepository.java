package com.example.alaa.car.repository;

import com.example.alaa.car.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
List<Teacher> findTeacherListBySubjectListId(Long subjectId);

}
