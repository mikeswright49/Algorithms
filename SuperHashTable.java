
public class SuperHashTable {

		private Node[][] table;
		
		public SuperHashTable(){
			table = new Node[1][];
		}
		
		public Node get(String key){
			int index = getHashIndex(key);
			if(index>table.length||table[index]==null)
				return null;
			return table[index][0];			
		}
		public void put(Node newNode){
			int index = getHashIndex(newNode.getValue());
			if(index>table.length){
				Node[][] newTable = new Node[index*2][];
				System.arraycopy(table, 0, newTable, 0, table.length);
				table = newTable;
			}
			placeNode(index, newNode);				
		}
		private void placeNode(int index, Node node){
			if(table[index]==null)
			{
				table[index]=new Node[1];
				table[index][0]=node;
			}
			else{
				Node[] newPlace = new Node[table[index].length+1];
				System.arraycopy(table[index], 0, newPlace, 0, table[index].length);
				newPlace[newPlace.length-1] = node;
				table[index]=newPlace;
			}
		}
		private int getHashIndex(String key){	
			return Integer.parseInt(key);
		}
}
