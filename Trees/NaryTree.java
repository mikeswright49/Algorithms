package Trees;

import java.util.ArrayList;

public class NaryTree extends Tree<Object> {

	public NaryTree(Object root) {
		super(root);
	}

	@Override
	public boolean Remove(Object element) {
		Node<Object> parent = depthFirstSearch(super.getRoot(), element);
		if(parent!=null){
			for(int i=0; i< parent.children.size(); i++){
				if(parent.children.get(i).getData().equals(element))
				{
					parent.children.remove(i);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean Add(Object element) {
		if(Contains(element))
			return false;
		else{
			super.getRoot().children.add(new Node<Object>(super.getRoot(), element));
			return true;
		}
	}

	@Override
	public boolean Contains(Object element) {
		return depthFirstSearch(super.getRoot(), element)!=null;
	}
	public Node<Object> breadthFirstSearch(ArrayList<Node<Object>> elements, Object element){
		ArrayList<Node<Object>> children = new ArrayList<Node<Object>>();
		for(Node<Object> child:elements){
			if(child.getData().equals(element))
				return child.parent;
			else
				children.addAll(child.children);
		}
		return children.size()>0?breadthFirstSearch(children, element):null;
	}
	public Node<Object> depthFirstSearch(Node<Object> currentNode, Object element){
		if(currentNode.getData().equals(element))
			return currentNode.parent;
		for(Node<Object> child : currentNode.children){
			if(depthFirstSearch(child, element)!=null)
				return child;
		}
		return null;		
	}
	

}
