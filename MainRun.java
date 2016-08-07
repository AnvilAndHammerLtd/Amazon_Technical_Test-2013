import java.util.ArrayList;
import java.util.Collections;

public class MainRun {
	//given name of the csv file will be stored here
	String nameOfCsv;
	//given depth from the user is stored here
	int depth;
	//so we can know in which depth we are in each iteration, we start from depth 0
	int currentDepth = 0;
	//the final NAME values for the given depth are stored here
	ArrayList<String> names = new ArrayList<String>();
	//we will be storing the new node (NAME) value whenever we want to go deeper in the tree
	String newNode = new String();
	
	public static void main(String[] args) {
		MainRun mainRun = new MainRun();
		ReadCSVFile readCSVFile = new ReadCSVFile();
		
		mainRun.nameOfCsv = args[0];
		mainRun.depth = Integer.parseInt(args[1]);
				
		/*read the current csv file that was given by the user and return all its values in an arraylist<String[]> 
		*which contains the values of PARENT_NAME at String[0] and NAME at String[1]
		*Example
		*	{
		*		[Farrington, Kings cross], [Moorgate, aldgate].....
		*	}
		*/
		ArrayList<String[]> pairValues = readCSVFile.whichCSVFileToRead(mainRun.nameOfCsv);
		
		//we need to start from somewhere in our tree and we know that we can identify the root node by having a PARENT_NAME of "NULL"
		//we pass in the method the NULL value and the pairValues which has all the nodes, and we iterate through all the values searching for a PARENT_NAME
		//value which is equal to "NULL" so we can find the root node
		mainRun.namesList("NULL", pairValues);
		
		
		System.out.println();	
		System.out.println();	
		System.out.println("NAME values from depth: " + mainRun.depth);	
		
		//sort the NAME values we got alphabetically
		Collections.sort(mainRun.names);
		
		//displaying the NAME values from the depth that was given
		for(int i=0; i<mainRun.names.size(); i++){
			System.out.println(mainRun.names.get(i));	
		}
		
	}//method - main
	
	public void namesList(String currentNode, ArrayList<String[]> pairValues){
		//loop through all our nodes finding the NAME values for the given depth, if we are not at the correct depth then we go deeper into the tree.
		//once we reach the depth we want we print out the NAME values for the current node we are.
		//when we reach the end tree of a node then we go back and we search again the other nodes until we search all the nodes in the tree
		for(int i=0; i<pairValues.size(); i++){
			System.out.println();
			System.out.println("current depth: " + currentDepth);
			System.out.println("Searching for PARENT_NAME: " + currentNode);
			System.out.println("From PARENT_NAME: \"" + pairValues.get(i)[0] + "\" To NAME: \"" + pairValues.get(i)[1] + "\"");
			
			//check to see if the current node has subnodes.
			//we compare the current node with the PARENT_NAME values and if its equal to one of those values then it means that this node has a subnode
			if(currentNode.equals(pairValues.get(i)[0])){
				//check if this depth we are in is the depth the user wants
				if(currentDepth == depth){
					System.out.println("\t\t\t\t\t\t\t\t\t ***** FOUND - Storing and printing the NAME value of this PARENT_NAME *****");
					System.out.println("\t\t\t\t\t\t\t\t\t\t\tNAME value: " + pairValues.get(i)[1]);

					//get the subnode value (NAME) of this parent node (PARENT_NAME)
					names.add(pairValues.get(i)[1]);
				}
				//if we are not at the desired depth then go deeper in the tree
				else{
					System.out.println("\t\t\t\t\t\t\t\t\t ***** FOUND - But we go deeper in the tree because we are not in the correct depth *****");
					//as we are not in the depth the user wants we increment our currentDepth value because we are now going to go deeper in our tree
					currentDepth++;
					//we store the current NAME value
					newNode = pairValues.get(i)[1];
					//recursion, we call the same method again but now we give it the current NAME value from this PARENT_NAME
					//which will then iterate again through all the PARENT_NAME values, in this way we can go deeper into the tree.
					//basically if the current node has a subnode then we simply move to that node.
					namesList(newNode, pairValues);
				}
			}//if(currentNode.equals(pairValues.get(i)[0]))
			else{
				//current node is not equal to the current PARENT_NAME value so do nothing
			}
			//if we are at the end of this for loop it means that we have looped with the current node through all the 
			//PARENT_NAME values and this means that for this current node we have explored it's whole depth.
			//so we decrease our currentDepth value because we are going one node back from were we came
			if(i == (pairValues.size()-1)){
				currentDepth--;
			}
		}//for loop - pairValues.size()
	}//method - namesList
}//class
