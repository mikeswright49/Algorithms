package Trees;

public abstract class Tree<T> {
	
	private Node<T> root;
	
	public Tree(T root){
		this.root = new Node<T>(null, root);		
	}
	
	public Node<T> getRoot(){
		return root;
	}
	public void setRoot(Node<T> newRoot)
	{
		this.root = newRoot;
	}
	public abstract boolean Remove(T element);
	public abstract boolean Add(T element);
	public abstract boolean Contains(T element);

}

