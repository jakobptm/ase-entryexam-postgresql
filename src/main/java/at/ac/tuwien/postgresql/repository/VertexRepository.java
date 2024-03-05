package at.ac.tuwien.postgresql.repository;

import at.ac.tuwien.postgresql.entity.Vertex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VertexRepository extends JpaRepository<Vertex, Long> {
}
