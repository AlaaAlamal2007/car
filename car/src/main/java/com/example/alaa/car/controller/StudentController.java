package com.example.alaa.car.controller;

import com.example.alaa.car.domain.InQueryRequest;
import com.example.alaa.car.domain.Student;
import com.example.alaa.car.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/student")
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;


//    @GetMapping("/get")
//    public @ResponseBody Student getStudent() {
//        Student student = new Student(1L, "John", "smith", "johnSmith@gmail.com");
//        return student;
//    }


    @GetMapping("/getAll")
    public @ResponseBody List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }


    @PutMapping("update/{id}")
    public @ResponseBody Student updateStudent(@PathVariable("id") Long studentId,@RequestBody Student updateStudent){
        return studentService.updateStudent(studentId,updateStudent);
    }

    @GetMapping("/get/{studentId}")
    public @ResponseBody Student getStudent(@PathVariable Long studentId){
        return studentService.getStudent(studentId);
    }
    @GetMapping("/getByFirstName/{firstName}")
    public @ResponseBody List<Student>  getByFirstName(@PathVariable String firstName){
        return studentService.getByFirstName(firstName);
    }
    @GetMapping("/getByFirstNameAndLastName/{firstName}/{lastName}")
    public @ResponseBody List<Student> getByFirstName(@PathVariable String firstName,@PathVariable String lastName){
        return studentService.getByFirstNameAndLastName(firstName,lastName);
    }
@GetMapping("/getStudentFirstLastNameByQuery/{firstName}/{lastName}")
    public List<Student> getByFirstNameAndLastNameByQuery(@PathVariable String firstName, @PathVariable String lastName){
        return studentService.getByFirstNameAndLastNameByQuery(firstName,lastName);
    }
    @GetMapping("/getByFirstNameIn")
    public List<Student> getByFirstNameIn(@RequestBody InQueryRequest inQueryRequest){
        return studentService.getByFirstNameIn(inQueryRequest);
    }
@GetMapping("/getAllWithPagination/{pageNo}/{pageSize}")
    public Page<Student> getAllStudentWithPagination(@PathVariable int pageNo,@PathVariable int pageSize) {

        Page<Student> students = studentService.getAllStudentWithPagination(pageNo,pageSize);
        return students;
    }
    @GetMapping("/getAllWithSort")
    public List<Student> getAllWithSort(){
        Sort sort= Sort.by(Sort.Direction.ASC,"firstName","id");
        return studentService.getAllWithSort();
    }
    @PutMapping("/updateStudent/{id}")
   Student updateStudentFirstName(@PathVariable Long id,@RequestBody Student updatedStudent){
      return studentService.updateStudentFirstName(id,updatedStudent);
    }
@PutMapping("/updateStudentName/{id}/{firstName}")
    public  String updateStudentFirstName(@PathVariable Long id,@PathVariable String firstName){
        return studentService.updateStudentFirstName(id,firstName)+" updated student";
    }
@DeleteMapping("/deleteByFirstName/{firstName}")
    public  String  deleteByStudentFirstName(@PathVariable String firstName){
        return studentService.deleteByStudentFirstName(firstName)+" deleted student";
    }
    @GetMapping("/getByCity/{city}")
    public List<Student> getByCity(@PathVariable String city){

        return studentService.getByCity(city);

    }

}
