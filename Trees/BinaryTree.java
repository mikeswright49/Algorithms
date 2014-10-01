package Trees;

import java.util.*;

public class BinaryTree extends Tree<Object>{

	public BinaryTree(Object root) {
		super(root);
	}

	@Override
	public boolean Remove(Object element) {
		if(!Contains(element))
			return false;
		else if(super.getRoot().getData().equals(element)){
			if(super.getRoot().children.size()==1)
				super.setRoot(new Node<Object>(null, super.getRoot().children.get(0).getData()));
			else if(super.getRoot().children.size()==2){
				super.setRoot(removeNode(super.getRoot(), (Number)element));
				return true;
			}
			else
				return false;
		}
		super.setRoot(removeNode(super.getRoot(), (Number)element));
		return true;
	}
	
	
	@Override
	public boolean Add(Object element) {
		return addNode(super.getRoot(), (Number)element);
	}

	@Override
	public boolean Contains(Object element) {
		return containsNode(super.getRoot(), (Number)element);
	}
	private Node<Object> removeNode(Node<Object> currentNode, Number element){
		if(currentNode.getData().equals(element))
		{
			if(currentNode.children.size()==1)
				return removeNode(currentNode.children.get(0), (Number)currentNode.children.get(0).getData());
			else if(currentNode.children.size()==2)
				return removeNode(currentNode.children.get(1), (Number)currentNode.children.get(0).getData());
		}
		else if(compare(currentNode.getData(), element)<0){
			return removeNode(currentNode.children.get(0), element);
		}
		return removeNode(currentNode.children.get(1), element);
	}
	public float compare(Object source, Object target){
		return ((Number)source).floatValue()-((Number)target).floatValue();
	}
	private boolean containsNode(Node<Object> currentNode, Number element){
		if((Number)currentNode.getData()==element)
			return true;
		else if(currentNode.children.size()==0)
			return false;
		else 
			return containsNode(compare(currentNode.getData(), element)<0?currentNode.children.get(0):currentNode.children.get(currentNode.children.size()-1), element);
	}
	private boolean addNode(Node<Object> currentNode, Number element){
		if(((Number)currentNode.getData()).floatValue()==element.floatValue()){
			return true;
		}
		
		if(currentNode.children.size()==0)
			currentNode.children.add(new Node<Object>(currentNode, element));
		else if(currentNode.children.size()==2)
			return addNode(compare(currentNode.getData(), element)<0?currentNode.children.get(0):currentNode.children.get(1), element);
		else{
			Node<Object> child = currentNode.children.get(0);
			if(((Number)child.getData()).floatValue()<element.floatValue())
				currentNode.children.add(new Node<Object>(currentNode, element));
			else{
				child.children = new ArrayList<Node<Object>>();
				currentNode.children.add(new Node<Object>(currentNode, element));
				currentNode.children.add(child);
			}			
		}
		return true;
			
	}

}
