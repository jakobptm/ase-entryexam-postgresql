package at.ac.tuwien.postgresql.service;

import at.ac.tuwien.postgresql.entity.Student;
import at.ac.tuwien.postgresql.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    public List<Student> findAll() {
        return repository.findAll();
    }

    public Student findById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Student with id: " + id + " not found"));
    }

    public String create(Student student) {
        repository.save(student);
        return "Student created successfully";
    }

    public String update(String id, Student student) {
        Student existingStudent = repository.findById(id).orElse(null);
        if (existingStudent != null) {
            existingStudent.setFirstname(student.getFirstname());
            existingStudent.setLastname(student.getLastname());
            repository.save(existingStudent);
            return "Student updated successfully";
        } else {
            throw new RuntimeException("Student with id: " + id + " not found");
        }
    }

    public String delete(String id) {
        Student existingStudent = repository.findById(id).orElse(null);
        if (existingStudent != null) {
            repository.delete(existingStudent);
            return "Student deleted successfully";
        } else {
            throw new RuntimeException("Student with id: " + id + " not found");
        }
    }

    public List<Student> search(String firstname, String lastname) {
        return repository.findByFirstAndLastname(firstname, lastname);
    }
}
