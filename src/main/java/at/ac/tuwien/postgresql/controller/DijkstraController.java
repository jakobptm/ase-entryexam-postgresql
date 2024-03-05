package at.ac.tuwien.postgresql.controller;

import at.ac.tuwien.postgresql.entity.Edge;
import at.ac.tuwien.postgresql.entity.Vertex;
import at.ac.tuwien.postgresql.service.DijkstraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rest/dijkstra")
public class DijkstraController {

    /*
    Two GET endpoints returning all elements that you had to previously query from the database;
    Two POST endpoints where you had to add one element to the database;
    One endpoint where you had to use Dijkstra to find the shortest path for a given instance.
    Db connection string is given, you can also have a look at the database.
     */

    @Autowired
    DijkstraService service;

    @GetMapping(value="/edges", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Edge> getAllEdges() {
        return service.findAllEdges();
    }

    @GetMapping(value="/vertices", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vertex> getAllVertices() {
        return service.findAllVertices();
    }

    @PostMapping(value="/edges", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createEdge(@RequestBody Edge edge) {
        return service.createEdge(edge);
    }

    @PostMapping(value="/vertices", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createVertex(@RequestBody Vertex vertex) {
        return service.createVertex(vertex);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String findShortestPath(@RequestParam("start") String start, @RequestParam("end") String end) {
        return service.findShortestPath(start, end);
    }
}
