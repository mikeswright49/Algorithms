package Trees;
import java.util.*;

public class Node<T>{
	private T data;
	public Node(Node<T> parent, T value){
		this.data = value;
		this.parent = parent;
		this.children = new ArrayList<Node<T>>();
	}
	public List<Node<T>> children;
	public Node<T> parent;
	
	public T getData(){
		return data;
	}
}
