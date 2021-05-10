import java.util.Objects;

public class Vertex {

    private String label;

    public Vertex(String label) {
        this.label = label;
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        } else if (obj == this) {
            return true;
        } else if (!(obj instanceof Vertex)) {
            return false;
        }

        Vertex objVertex = (Vertex) obj;
        return Objects.equals(this.toString(), objVertex.toString());
    }

    @Override
    public String toString() {
        return this.label;
    }

}

