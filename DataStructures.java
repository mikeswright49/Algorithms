import java.util.Hashtable;


public class DataStructures {
	private Node node1 = new Node("5", 32, 4);
	private Node node4 = new Node("4", 52, 3);
	private Node node3 = new Node("3", 1, 2);
	private Node node2 = new Node("2", 8, 1);
	private Node node5 = new Node("1", 2, 0);

	
	private int[][] adjacencyMatrix = new int[5][5];
	private Hashtable<Node, Node[]> adjacencyList = new Hashtable<Node, Node[]>();
	
	public DataStructures(){
		
		adjacencyMatrix[0][0] = 0;
		adjacencyMatrix[0][1] = 0;
		adjacencyMatrix[0][2] = node3.getWeight();
		adjacencyMatrix[0][3] = 0;
		adjacencyMatrix[0][4] = node1.getWeight();

		adjacencyMatrix[1][0] = 0;
		adjacencyMatrix[1][1] = 0;
		adjacencyMatrix[1][2] = node2.getWeight();
		adjacencyMatrix[1][3] = node4.getWeight();
		adjacencyMatrix[1][4] = node1.getWeight();
	
		adjacencyMatrix[2][0] = 0;
		adjacencyMatrix[2][1] = -node2.getWeight();
		adjacencyMatrix[2][2] = 0;
		adjacencyMatrix[2][3] = 0;
		adjacencyMatrix[2][4] = 0;
		
		adjacencyMatrix[3][0] = 0;
		adjacencyMatrix[3][1] = -node4.getWeight();
		adjacencyMatrix[3][2] = 0;
		adjacencyMatrix[3][3] = 0;
		adjacencyMatrix[3][4] = 0;
		
		adjacencyMatrix[4][0] = -node5.getWeight();
		adjacencyMatrix[4][1] = -node1.getWeight();
		adjacencyMatrix[4][2] = 0;
		adjacencyMatrix[4][3] = 0;
		adjacencyMatrix[4][4] = 0;
		
		Node[] nodes = new Node[2];
		nodes[0] = node3;
		nodes[1] = node5;
		adjacencyList.put(node1, nodes);
		
		nodes = new Node[3];
		nodes[0] = node3;
		nodes[1] = node2;
		nodes[2] = node5;
		adjacencyList.put(node2, nodes);
		
		nodes = new Node[1];
		nodes[0] = node2;
		adjacencyList.put(node3, nodes);
		
		nodes = new Node[1];
		nodes[0] = node2;
		adjacencyList.put(node4, nodes);
		

		nodes = new Node[2];
		nodes[0] = node1;
		nodes[1] = node2;
		adjacencyList.put(node4, nodes);
		
		
	}
	public int[][] getAdjacencyMatrix(){
		return adjacencyMatrix;
	}
	public Hashtable<Node, Node[]> getAdjacencyList(){
		return adjacencyList;
	}
	
}
