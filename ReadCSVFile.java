import java.io.*;
import java.util.ArrayList;

public class ReadCSVFile {
	
	public  ArrayList<String[]> whichCSVFileToRead(String givenCsvFileName){
	    String line = null;
	    BufferedReader stream = null;
	    //storing PARENT_NAME and NAME as pair values
		//String[] valuePair = new String[2];
		//storing all our pairs
	    ArrayList<String[]> dataLine = new ArrayList<String[]>();
	    String[] splitted;
	    
	    try {
	    	stream = new BufferedReader(new FileReader(givenCsvFileName));
	    	int i=0;
	    	
	        System.out.println();
	        System.out.println("VALUES FROM CSV FILE");
	        System.out.println();

	    	//reads the whole csv file line by line
	    	while ((line = stream.readLine()) != null) {	        	
	        	//storing from this current line our column values into an array one by one
	    		splitted = line.split(",");	            
	            dataLine.add(splitted);
	            
		        System.out.println("PARENT_NAME: " + dataLine.get(i)[0]);
		        System.out.println("NAME: " + dataLine.get(i)[1]);
		        System.out.println();
	            
		        i++;
	        }
	    	stream.close();
	    }
	    catch(FileNotFoundException e){
	    	System.out.println();
	    	System.out.println(e);
	    	System.out.println();
	    }
	    catch(IOException e){
	    }
	    catch(Exception e){
	    }
	    //we are removing from the pair values the header values
	    dataLine.remove(0);
	    return dataLine;
	}
}