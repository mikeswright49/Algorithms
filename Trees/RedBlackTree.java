package Trees;

public class RedBlackTree{
	private BinaryNode root;
	public RedBlackTree(int root){
		this.root = new BinaryNode(root, false, null);	
	}


	public boolean Remove(int element) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean Add(int element) {
		AddNode(root, null, element);
		return true;
	}
	private void AddNode(BinaryNode currentNode, BinaryNode parent, int element){
		if(currentNode==null){
			currentNode = new BinaryNode(element, true, parent);
			AdjustAfterInsert(currentNode);
		}
		else if(currentNode.data < element){
			AddNode(currentNode.right, currentNode, element);
		}
		else{
			AddNode(currentNode.left, currentNode, element);
		}
	}
	private void AdjustAfterInsert(BinaryNode node){
		if(node!=null&&node.parent!=null&&node.colored){
			if(getSibling(node.parent)!=null&&getSibling(node.parent).colored){
				node.parent.colored = false;
				getSibling(node.parent).colored = false;
				if(node.parent.parent!=null){
					node.parent.parent.colored = true;
					AdjustAfterInsert(node.parent.parent);
				}
			}
			else if(node.parent==getGrandparentNode(node.parent, true)){
				if(node==node.parent.right){
					rotateLeft(node.parent);
				}
				node.parent.colored = false;
				if(node.parent.parent!=null){
					node.parent.parent.colored = true;
					rotateRight(node.parent.parent);
				}				
			}
			else if(node.parent==getGrandparentNode(node.parent, false)){
				if(node==node.parent.left){
					rotateRight(node.parent);
				}
				node.parent.colored = false;
				if(node.parent.parent!=null){
					node.parent.parent.colored = true;
					rotateLeft(node.parent.parent);
				}
			}
		}
		root.colored = false;
	}
	private void rotateRight(BinaryNode node){
	
	}
	private void rotateLeft(BinaryNode node){
		
	}
	private BinaryNode getGrandparentNode(BinaryNode parent, boolean left){
		return parent.parent==null?null:left?parent.parent.left:parent.parent.right;
	}
	private BinaryNode getSibling(BinaryNode node){
		if(node.parent==null)
			return null;
		if(node.parent.left.equals(node))
			return node.parent.right;
		else
			return node.parent.left;
	}
	public boolean Contains(int element) {
		// TODO Auto-generated method stub
		return false;
	}
}
