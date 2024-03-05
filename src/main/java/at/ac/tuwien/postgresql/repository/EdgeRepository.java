package at.ac.tuwien.postgresql.repository;

import at.ac.tuwien.postgresql.entity.Edge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdgeRepository extends JpaRepository<Edge, Long> {
}
