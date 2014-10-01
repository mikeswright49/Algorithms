package Trees;

public class TrieTree extends Tree<Object> {

	public TrieTree(String root) {
		super(' ');
		Add(root);
	}

	@Override
	public boolean Remove(Object element) {
		if(!(element instanceof String)||!Contains(element)){
			return false;
		}
		return findTop(super.getRoot(), (String)element);
	}

	@Override
	public boolean Add(Object element) {
		if(!(element instanceof String)){
			return false;
		}
		return append(super.getRoot(), (String)element);
	}

	@Override
	public boolean Contains(Object element) {
		if(!(element instanceof String)){
			return false;
		}
		return traverseDown(super.getRoot(), (String)element);
	}
	
	public boolean findTop(Node<Object> currentNode, String element){
		
		int leaf = containsNode(currentNode, element);
		
		if(currentNode.children.get(leaf).children.size()<2){
			currentNode.parent.children.remove(currentNode);
			return true;
		}
		else{
			element = element.substring(1);
			return findTop(currentNode.children.get(leaf), element);
		}
	}
	
	
	public int containsNode(Node<Object> leaf, Object element){
		for(int i=0; i<leaf.children.size(); i++){
			if(leaf.children.get(i).getData()==element)
				return i;
		}
		return -1;
	}
	private boolean traverseDown(Node<Object> currentNode, String remaining){
		if(remaining.length()==0)
			return true;
		
		int child = containsNode(currentNode, remaining.charAt(0));
		if(child==-1)
			return false;
		
		remaining = remaining.substring(1);
		return traverseDown(currentNode.children.get(child), remaining);
		
	}
	private boolean append(Node<Object> currentNode, String remaining){
		if(remaining.length()==0)
			return true;
		int childLeaf = containsNode(currentNode, remaining.charAt(0));
		if(childLeaf!=-1){
			remaining = remaining.substring(1);
			return append(currentNode.children.get(childLeaf), remaining);
		}
		else{
			currentNode.children.add(new Node<Object>(currentNode, remaining.charAt(0)));
			remaining = remaining.substring(1);
			return append(currentNode.children.get(currentNode.children.size()-1), remaining);
		}
	}
	

}
