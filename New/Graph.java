public class Graph {
    private int numVertices;
    private HashTables adjList;
    public Graph(int n) {
        this.numVertices = n;
        this.adjList = new HashTables(n);
    }
    // AddVertex
    public void addVertex(int v) {
        adjList.insert(v);
    }
    // AddEdge
    public void addEdge(int src, int dest){
        adjList.insertAtKey(src, dest);
        adjList.insertAtKey(dest, src);
    }
    public void display(){
        adjList.display();
    }
    public void bfs(int v){
        boolean[] visited = new boolean[numVertices];
        LinkedLists queue = new LinkedLists();
        queue.append(v);
        visited[adjList.searchKey(v)] = true;
        System.out.print(v+" ");
        while(queue.head != null){
            int vertex = queue.removeFront();
            int current = adjList.searchKey(vertex);
            Node ptr = adjList.arr[current].head.next;
            while(ptr != null){
                if (visited[adjList.searchKey(ptr.data)] == false){
                    System.out.print(ptr.data+" ");
                    queue.append(ptr.data);
                    visited[adjList.searchKey(ptr.data)] = true;
                }
                ptr = ptr.next;
            }
        }
    }
    // get neghbours of vertex
    public LinkedLists getNeighbours(int v){
        LinkedLists n = new LinkedLists();
        int current = adjList.searchKey(v);
        Node ptr = adjList.arr[current].head.next;
        while(ptr != null){
            n.append(ptr.data);
            ptr = ptr.next;
        }
        return n;
    }
    public static void main(String[] args) {
        Graph g = new Graph(10);
        g.addVertex(232);g.addVertex(5);g.addVertex(33);g.addVertex(2);g.addVertex(112);g.addVertex(921);g.addVertex(92);
        g.addVertex(22);g.addEdge(33, 112);g.addEdge(33, 232);g.addEdge(232, 112);g.addEdge(2, 112);
        g.addEdge(921, 112);g.addEdge(921, 5);g.addEdge(92, 921);g.addEdge(92, 5);
        g.addEdge(22, 92);g.addEdge(5, 22);g.addEdge(22, 921);
        System.out.println("Adjacency List Representation: ");
        g.display();
        System.out.print("BFS: ");
        g.bfs(232);
        System.out.println("");
        System.out.print("BFS: ");
        g.bfs(112);
        System.out.println("");
        System.out.print("BFS: ");
        g.bfs(92);
    }
}
