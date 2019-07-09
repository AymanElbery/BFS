package github.aymanelbery;

import java.util.*;
import java.util.Scanner;


public class BFS {

    private Queue<Node> queue;
    static ArrayList<Node> nodes=new ArrayList<Node>();


    public BFS()
    {
        queue = new LinkedList<Node>();
    }

    /*
    * Main Algorithm
    *
    * I use BFS algorithm because it is the best choice to find shortest path between
    * two nodes in unweighted and undirected graph.
    * */
    public void search(Node node, int givenId)
    {
        queue.add(node);
        node.visited = true;
        node.parent = 0;
        int path = 0;
        int notFound = -1;
        boolean ok = true;
        while (!queue.isEmpty() && ok) {
            Node element = queue.remove();
            List<Node> adjs = element.getAdj();
            for (int i = 0; i < adjs.size(); i++) {
                Node n = adjs.get(i);
                if(n != null && !n.visited) {
                    queue.add(n);
                    n.visited = true;
                    n.parent = element.parent+1;
                    path = n.parent;
                    if (n.id == givenId){
                        System.out.print("path = " + path + "\n");
                        ok = false;
                        notFound = 0;
                        break;
                    }
                }
            }
        }
        if(notFound == -1 && ok) System.out.print("path = " + notFound + "\n");
    }

    public static void main(String[] args) {

        /*
         * Input (n) number of nodes, and (m) number of edges
         * */
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();

        /*
         * Create array of Nodes ...
         * */
        Node[] myNodes = new Node[n];
        for (int i=0; i<myNodes.length; i++){
            myNodes[i] = new Node();
        }

        /*
         * Create adjacency list for every Node recursively
         * */
        for (int j=0; j<m; j++){
            int u = input.nextInt();
            int v = input.nextInt();
            myNodes[u-1].addAdj(myNodes[v-1]);
            myNodes[v-1].addAdj(myNodes[u-1]);
        }

        /*
         * Input ids of every Node
         * */
        for (int c=0; c<myNodes.length; c++){
            int id = input.nextInt();
            myNodes[c].setId(id);
        }

        /*
        * Start time to calculate execution time of algorithm
        * */
        long startTime = System.currentTimeMillis();


        BFS bfsObj = new BFS();
        int givenId = input.nextInt();

        /*
        * Loop to get target node by id
        * */
        for (int g = 0; g < myNodes.length; g++){
            if (myNodes[g].id == givenId){

                // start algorithm ..
                bfsObj.search(myNodes[g], givenId);

                /*
                 * Calc execution time and end loop
                 * */
                System.out.println("Time limit = " + ((System.currentTimeMillis() - startTime) / 1000F) + " second");
                break;
            }
        }
    }
}
