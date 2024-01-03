package com.example.alaa.car.controller;

import com.example.alaa.car.domain.Subject;
import com.example.alaa.car.domain.Teacher;
import com.example.alaa.car.repository.SubjectRepository;
import com.example.alaa.car.repository.TeacherRepository;
import com.example.alaa.car.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/subject")
@RestController
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @PutMapping("/{subjectId}/teacher/{teacherId}")
    public Subject assignTeacherToSubject(@PathVariable Long subjectId,
                                          @PathVariable Long teacherId){
       Subject subject=subjectService.assignTeacherToSubject(subjectId,
               teacherId);
        return  subject;
    }

    @DeleteMapping("/{subjectId}/teacher/{teacherId}")
    public String deleteSubjectAssignedtToTeacher(@PathVariable Long subjectId,
                                               @PathVariable Long teacherId){
        subjectService.deleteSubjectAssignetToTeacher( subjectId,
                 teacherId);
       return "delete";
    }
    @PostMapping
    public Subject createSubject(@RequestBody Subject subject){
        return subjectService.createSubject(subject);
    }

    @GetMapping("/{subjectId}")
    public Subject getSubject(@PathVariable Long subjectId){
       return subjectService.getSubject(subjectId);
    }
    @GetMapping("/{subjectId}/teacher")
    public @ResponseBody List<Teacher> getAllTeachersBySubjectId(@PathVariable Long subjectId){

        return subjectService.getAllTeacherBySubjectId(subjectId );
    }
    @GetMapping
    public List<Subject> getAllSubjects(){
        return subjectService.getAllSubjects();
    }
    @DeleteMapping("/{subjectId}")
    public void deleteSubject(@PathVariable Long subjectId){
        subjectService.deleteSubject(subjectId);

    }

}
