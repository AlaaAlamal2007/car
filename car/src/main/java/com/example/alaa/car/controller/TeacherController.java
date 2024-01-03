package com.example.alaa.car.controller;

import com.example.alaa.car.domain.Teacher;
import com.example.alaa.car.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.Subject;
import java.util.List;

@RequestMapping("/api/teacher")
@RestController
public class TeacherController {
    @Autowired
    TeacherService teacherService;


    @GetMapping("/{teacherId}")
    public Teacher getTeacher(@PathVariable Long teacherId){
        return
                teacherService.getTeacher(teacherId);
    }


    @GetMapping
    public List<Teacher> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher teacher){

        return teacherService.createTeacher(teacher);
    }
    @PutMapping("/update/{teacherId}")
    public Teacher updateTeacher(@PathVariable Long teacherId,@RequestBody Teacher updateTeacher){
        return teacherService.updateTeacher(teacherId,updateTeacher);
    }
    @DeleteMapping("/{teacherId}")
    public void deleteTeacher(@PathVariable Long teacherId){
        teacherService.deleteTeacher(teacherId);

    }

}


