package com.example.alaa.car.service;

import com.example.alaa.car.controller.exception.ResourceNotFoundException;
import com.example.alaa.car.domain.Subject;
import com.example.alaa.car.domain.Teacher;
import com.example.alaa.car.repository.SubjectRepository;
import com.example.alaa.car.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    SubjectRepository subjectRepository;


    public Teacher getTeacher(Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + teacherId)
                );
        return teacher;
    }


    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }


    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Long teacherId, Teacher updateTeacher) {
        Teacher teacher = new Teacher();
        if (teacherRepository.findById(teacherId) != null) {
            teacherRepository.deleteById(teacherId);
            teacher.setName(updateTeacher.getName());
            teacher.setSubjectList(updateTeacher.getSubjectList());

        } else {
            throw new ResourceNotFoundException("does not exist");
        }
        return teacherRepository.save(teacher);
    }

    public void deleteTeacher(Long teacherId) {
//        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(
//                () -> new ResourceNotFoundException("does not exist")
//        );
//        Set<Subject> subjects = teacher.getSubjectList();
//        if (subjects != null) {
//            subjects.forEach(subject ->
//                    subject.deleteSubjectAssignetToTeacher(subject.getId(), teacherId));
//        }
//        teacherRepository.deleteById(teacherId);
    }
}

