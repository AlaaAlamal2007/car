package com.example.alaa.car.repository;

import com.example.alaa.car.domain.Student;
import com.example.alaa.car.domain.Subject;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    @Query("from Student where firstName=:firstName and lastName=:lastName")
    List<Student> getByFirstNameAndLastName(String firstName, String lastName);

    List<Student> findByFirstNameIn(List<String> firstNames);

    @Modifying
    @Transactional
    @Query("Update Student set firstName=:firstName where id=:id")
    Integer updateStudentFirstName(Long id, String firstName);

    @Modifying
    @Transactional
    @Query("Delete From Student where firstName=:firstName")
    Integer deleteByStudentFirstName(String firstName);

    List<Student> findByAddressCity(String city);

    @Query("From Student where address.city=:city")
    List<Student> getByAddressCity(String city);

    @Query("From Student where address.id=:id")
    Student findByAddressId(Long id);

@Query("From  Student")
    List<Student> getAll();
}
