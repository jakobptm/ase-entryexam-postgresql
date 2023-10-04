package at.ac.tuwien.postgresql.repository;

import at.ac.tuwien.postgresql.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    @Query("select s from Student s where s.firstname = ?1 and s.lastname = ?2")
    List<Student> findByFirstAndLastname(String firstname, String lastname);
}
