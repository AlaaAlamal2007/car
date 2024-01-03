package com.example.alaa.car.service;

import com.example.alaa.car.domain.Address;
import com.example.alaa.car.domain.InQueryRequest;
import com.example.alaa.car.domain.Student;
import com.example.alaa.car.domain.Subject;
import com.example.alaa.car.repository.AddressRepository;
import com.example.alaa.car.repository.StudentRepository;
import com.example.alaa.car.repository.SubjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    SubjectRepository subjectRepository;


    public List<Student> getAllStudents() {
        List<Student> students=studentRepository.findAll();
//        for(Student st:students){
//            List<Subject> subjectList=subjectRepository.getByStudentId(st.getId());
//            st.setLearningSubjects(subjectList);
//        }

        return students;
    }

    public Student createStudent(Student student) {

        Address address = new Address();
        address.setStreet(student.getAddress().getStreet());
        address.setCity(student.getAddress().getCity());
        address=addressRepository.save(address);
        student.setAddress(address);
        Student st=studentRepository.save(student);

        List<Subject> newSubjectList=new ArrayList<>();
        if(student.getLearningSubjects()!=null){
            for(Subject sub:student.getLearningSubjects()){
                Subject subject=new Subject();
                subject.setSubjectName(sub.getSubjectName());
                subject.setMarksObtained(sub.getMarksObtained());
                subject.setStudent(sub.getStudent());
                subject=subjectRepository.save(subject);
                newSubjectList.add(subject);
            }
        }


           // st.setLearningSubjects(newSubjectList);
        return st;
    }

    public Student updateStudent(Long studentId, Student updateStudent) {
        Student oldStudent = studentRepository.findById(studentId).orElse(null);
        if (oldStudent == null) {
            throw new RuntimeException("student not exist");
        }
        studentRepository.deleteById(studentId);


        return studentRepository.save(updateStudent);
    }

    public Student getStudent(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student does not exist"));
        List<Subject> subjects=subjectRepository.getByStudentId(studentId);
      //  student.setLearningSubjects(subjects);
        return student;
    }

    public List<Student> getByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }

    public List<Student> getByFirstNameAndLastName(String firstName, String lastName) {
        return studentRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public List<Student> getByFirstNameAndLastNameByQuery(String firstName, String lastName) {
        return studentRepository.getByFirstNameAndLastName(firstName, lastName);
    }

    public List<Student> getByFirstNameIn(InQueryRequest inQueryRequest) {
        return studentRepository.findByFirstNameIn(inQueryRequest.getFirstNames());
    }

    public Page<Student> getAllStudentWithPagination(int pageNo, int pageSize) {

        Page<Student> students = studentRepository.findAll(PageRequest.of(pageNo - 1, pageSize));
        return students;
    }

    public List<Student> getAllWithSort() {
        Sort sort = Sort.by(Sort.Direction.ASC, "firstName");
        return studentRepository.findAll(sort);
    }

    public Student updateStudentFirstName(Long id, Student student) {
        studentRepository.deleteById(id);
        return studentRepository.save(student);
    }

    public Integer updateStudentFirstName(Long id, String firstName) {
        return studentRepository.updateStudentFirstName(id, firstName);
    }

    public Integer deleteByStudentFirstName(String firstName) {
        return studentRepository.deleteByStudentFirstName(firstName);
    }

    public List<Student> getByCity(String city){

        return studentRepository.getByAddressCity(city);

    }
}
