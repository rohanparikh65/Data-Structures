package prereqchecker;
import java.util.*;

/**
 * Steps to implement this class main method:
 * 
 * Step 1:
 * AdjListInputFile name is passed through the command line as args[0]
 * Read from AdjListInputFile with the format:
 * 1. a (int): number of courses in the graph
 * 2. a lines, each with 1 course ID
 * 3. b (int): number of edges in the graph
 * 4. b lines, each with a source ID
 * 
 * Step 2:
 * AdjListOutputFile name is passed through the command line as args[1]
 * Output to AdjListOutputFile with the format:
 * 1. c lines, each starting with a different course ID, then 
 *    listing all of that course's prerequisites (space separated)
 */
public class AdjList {

    public static void print(HashMap<String, ArrayList<String>> adjList){
        for (Map.Entry mapElement : adjList.entrySet()){
            String key = (String)mapElement.getKey();
            String pr = new String();
            for(int i=0; i<adjList.get(key).size(); i++){
                pr += adjList.get(key).get(i) + " ";
            }
            StdOut.print(key + " " + pr);
            StdOut.println();
        }
    }
    public static void main(String[] args) {

        if ( args.length < 2 ) {
            StdOut.println("Execute: java -cp bin prereqchecker.AdjList <adjacency list INput file> <adjacency list OUTput file>");
            return;
        }


	// WRITE YOUR CODE HERE
    StdIn.setFile(args[0]);
    StdOut.setFile(args[1]);
    int nc = Integer.parseInt(StdIn.readLine());
    HashMap<String, ArrayList<String>> aL = new HashMap<String, ArrayList<String>>();
    for(int i=0; i<nc; i++){
        String cn = StdIn.readLine();
        aL.put(cn, new ArrayList<String>());
    }
    int ne = Integer.parseInt(StdIn.readLine());
    for(int i=0; i<ne; i++){
        String c = StdIn.readLine();
        String[] v = c.split(" ");

        aL.get(v[0]).add(v[1]);
    }
    AdjList.print(aL);
    
    
    }
}
