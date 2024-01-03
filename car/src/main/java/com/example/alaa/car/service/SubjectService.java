package com.example.alaa.car.service;

import com.example.alaa.car.controller.exception.ResourceNotFoundException;
import com.example.alaa.car.domain.Student;
import com.example.alaa.car.domain.Subject;
import com.example.alaa.car.domain.Teacher;
import com.example.alaa.car.repository.StudentRepository;
import com.example.alaa.car.repository.SubjectRepository;
import com.example.alaa.car.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
private StudentRepository studentRepository;
    public Subject assignTeacherToSubject(Long subjectId, Long teacherId) {

        Subject subject = subjectRepository.findById(subjectId).get();
        Teacher teacher = teacherRepository.findById(teacherId).get();
        teacher.addSubject(subject);

        return subjectRepository.save(subject);
    }


    public Subject createSubject(Subject subject) {

        return subjectRepository.save(subject);
    }

    public Subject getSubject(Long subjectId) {

        return subjectRepository.findById(subjectId).get();
    }

    public void deleteSubjectAssignetToTeacher(Long subjectId, Long teacherId) {

        Subject subject = subjectRepository.findById(subjectId).get();
        Teacher teacher = teacherRepository.findById(teacherId).get();
        subject.deleteAssignTeacher(teacher);
        teacher.removeSubject(subject.getId());
        teacherRepository.save(teacher);

    }


    public List<Teacher> getAllTeacherBySubjectId(Long subjectId) {
        Subject subject = subjectRepository.findById(subjectId).get();
        List<Teacher> teachers = teacherRepository.findTeacherListBySubjectListId(subjectId);
        return teachers;
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }
@Transactional
    public void deleteSubject(Long subjectId) {
        Subject subject=subjectRepository.findById(subjectId).orElseThrow(
                ()->new ResourceNotFoundException("subject does not exist")
        );
        Student student=subject.getStudent();

        Set<Teacher> teachers=subject.getTeacherList();
        if(!teachers.isEmpty()&&teachers!=null){
       teachers.forEach(teacher->
               deleteSubjectAssignetToTeacher(subjectId,teacher.getId()));}
        subjectRepository.deleteAllByStudentId(subject.getStudent().getId());

        }



}
