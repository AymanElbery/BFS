package github.aymanelbery;

import java.util.ArrayList;
import java.util.List;

public class Node
{
    int id;
    boolean visited;
    List<Node> adj;
    int parent;

    Node()
    {
        this.adj = new ArrayList<>();
    }


    public void setId(int id)
    {
        this.id = id;
    }


    public void addAdj(Node adjNode)
    {
        this.adj.add(adjNode);
    }


    public List<Node> getAdj() {
        return adj;
    }
}
