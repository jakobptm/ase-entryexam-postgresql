package at.ac.tuwien.postgresql.service;

import at.ac.tuwien.postgresql.entity.Edge;
import at.ac.tuwien.postgresql.entity.Vertex;
import at.ac.tuwien.postgresql.repository.EdgeRepository;
import at.ac.tuwien.postgresql.repository.VertexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DijkstraService {

    @Autowired
    EdgeRepository edgeRepository;

    @Autowired
    VertexRepository vertexRepository;

    public List<Edge> findAllEdges() {
        return edgeRepository.findAll();
    }

    public List<Vertex> findAllVertices() {
        return vertexRepository.findAll();
    }

    public String createEdge(Edge edge) {
        edgeRepository.save(edge);
        return "Edge created successfully";
    }

    public String createVertex(Vertex vertex) {
        vertexRepository.save(vertex);
        return "Vertex created successfully";
    }

    public String findShortestPath(String start, String end) {
        return null;
    }
}
