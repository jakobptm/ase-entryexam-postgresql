package at.ac.tuwien.postgresql.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "edge")
public class Edge implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vertex source;

    @ManyToOne
    private Vertex destination;

    @Column(name = "weight")
    private int weight;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public Vertex getDestination() {
        return destination;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge edge)) return false;

        if (weight != edge.weight) return false;
        if (!id.equals(edge.id)) return false;
        if (!source.equals(edge.source)) return false;
        return destination.equals(edge.destination);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + source.hashCode();
        result = 31 * result + destination.hashCode();
        result = 31 * result + weight;
        return result;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "id=" + id +
                ", source=" + source +
                ", destination=" + destination +
                ", weight=" + weight +
                '}';
    }
}
