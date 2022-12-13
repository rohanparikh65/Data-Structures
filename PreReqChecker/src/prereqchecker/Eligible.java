package prereqchecker;

import java.util.*;

/**
 * 
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
 * EligibleInputFile name is passed through the command line as args[1]
 * Read from EligibleInputFile with the format:
 * 1. c (int): Number of courses
 * 2. c lines, each with 1 course ID
 * 
 * Step 3:
 * EligibleOutputFile name is passed through the command line as args[2]
 * Output to EligibleOutputFile with the format:
 * 1. Some number of lines, each with one course ID
 */
public class Eligible {
    private static void Completed(String c, HashMap<String, ArrayList<String>> pr, HashSet<String> completed) {
        if (completed.contains(c))
            return;
        completed.add(c);
        ArrayList<String> reqs = pr.get(c);
        for (String prerq : reqs)
            Completed(prerq, pr, completed);
    }
    private static boolean eligiblefor(String c, HashMap<String, ArrayList<String>> pr, HashSet<String> completed) {
        if (completed.contains(c))
            return false;
        for (String prerq : pr.get(c))
            if (!completed.contains(prerq))
                return false;
        return true;
    }
    public static void main(String[] args) {

        if ( args.length < 3 ) {
            StdOut.println("Execute: java -cp bin prereqchecker.Eligible <adjacency list INput file> <eligible INput file> <eligible OUTput file>");
            return;
        }

        StdIn.setFile(args[0]);
        
        HashMap<String, ArrayList<String>> prereq = new HashMap<>();

        int numCourses = StdIn.readInt();
        for (int i = 0; i < numCourses; i++) {
            String c = StdIn.readString();
            prereq.put(c, new ArrayList<String>());
        }
        
        int numEdges = StdIn.readInt();
        for (int i = 0; i < numEdges; i++) {
            String c1 = StdIn.readString();
            String pr = StdIn.readString();
            prereq.get(c1).add(pr);
        }

        StdIn.setFile(args[1]);

        HashSet<String> completed = new HashSet<>();
        
        int numCompletedCourses = StdIn.readInt();
        for (int i = 0; i < numCompletedCourses; i++) {
            String course = StdIn.readString();
            Completed(course, prereq, completed);
        }

        StdOut.setFile(args[2]);
        
        for (String c : prereq.keySet())
            if (eligiblefor(c, prereq, completed))
                StdOut.println(c);
    }
}
