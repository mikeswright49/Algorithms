import java.util.ArrayList;


public class Node {

	private String value;
	private ArrayList<Node> children;
	private int weight;
	private int id;
	
	public Node(String value, int weight, int id){
		this.value = value;
		this.weight = weight;
		this.children = new ArrayList<Node>();
		this.id = id;
	}
	
	public int getWeight(){
		return weight;
	}
	public String getValue(){
		return value;
	}
	public void AddChild(Node child){
		this.children.add(child);
	}
	public ArrayList<Node> GetChildren(){
		return children;
	}
	public Node GetChild(int index){
		if(index>children.size())
			return null;
		else
			return children.get(index);
	}
	public int getId(){
		return id;
	}
}
