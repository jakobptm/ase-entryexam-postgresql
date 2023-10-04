package at.ac.tuwien.postgresql.controller;

import at.ac.tuwien.postgresql.entity.Student;
import at.ac.tuwien.postgresql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/api/rest/student")
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student findById(@PathVariable("id") String id) {
        try {
            return service.findById(id);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping
    public String create(@RequestBody Student student) {
        return service.create(student);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") String id, @RequestBody Student student) {
        try {
            return service.update(id, student);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") String id) {
        try {
            return service.delete(id);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> search(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname) {
        return service.search(firstname, lastname);
    }
}
