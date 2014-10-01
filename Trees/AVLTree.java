package Trees;

public class AVLTree {
	private BinaryNode root;
	public AVLTree(int root){
		this.root = new BinaryNode(root);
	}
	public void Insert(int element){
		InsertNode(root, null, element);
	}
	public void InsertNode(BinaryNode currentNode, BinaryNode parent, int element){
		if(currentNode==null){
			currentNode = new BinaryNode(element, false, parent);
			balanceTree(parent);
		}
		else if(currentNode.data < element){
			InsertNode(currentNode.right, currentNode, element);
		}
		else{
			InsertNode(currentNode.left, currentNode, element);
		}
			
	}
	public int getHeight(BinaryNode node){
		int height = 0;
		if(node.left!=null)
			height++;
		if(node.right!=null)
			height--;
		return height;
	}
	public void balanceTree(BinaryNode parent){
		int height = getHeight(parent);
		int parentHeight = Math.abs(height)+getHeight(parent.parent);
		
		if(parentHeight==2){
			
		}
		
	}
	public void Delete(int element){
		
	}

}
