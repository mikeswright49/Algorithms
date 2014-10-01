package Trees;

public class BinaryNode {

	public boolean colored;
	public BinaryNode left;
	public BinaryNode right;
	public BinaryNode parent;
	public int data;
	public BinaryNode(int data){
		this(data, false, null);
	}
	public BinaryNode(int data, boolean colored, BinaryNode parent){
		this.colored = colored;
		this.data = data;
		this.parent = parent;
	}
}
