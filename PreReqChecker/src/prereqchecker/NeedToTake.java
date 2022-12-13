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
 * NeedToTakeInputFile name is passed through the command line as args[1]
 * Read from NeedToTakeInputFile with the format:
 * 1. One line, containing a course ID
 * 2. c (int): Number of courses
 * 3. c lines, each with one course ID
 * 
 * Step 3:
 * NeedToTakeOutputFile name is passed through the command line as args[2]
 * Output to NeedToTakeOutputFile with the format:
 * 1. Some number of lines, each with one course ID
 */
public class NeedToTake {

    private static String PRcheck(String c) {
        int q = c.indexOf(" ");
            String compare = new String();
            if (q != -1) {
                compare = c.substring(0,q);
            } else {
                compare = c;
            }

            return compare;
        }

    private static void shortl(String t, ArrayList<String> ot) {
        int a = t.indexOf(" ");
        if (a == -1) {
            return;
        }
        else {
            
            t = t.substring(a + 1);
            int check = 0;
            if (ot.size() > 0) {
            for (int i = 0; i < ot.size(); i++) {
                if (ot.get(i).compareTo(PRcheck(t)) == 0) {
                    check = 1;
                }
            }
            }
            if (check == 0) {
            ot.add(PRcheck(t));
            }
            shortl(t, ot);
        }
    }
    public static void main(String[] args) {

        if ( args.length < 3 ) {
            StdOut.println("Execute: java NeedToTake <adjacency list INput file> <need to take INput file> <need to take OUTput file>");
            return;
        }

	// WRITE YOUR CODE HERE
    StdIn.setFile(args[0]);
    if (StdIn.isEmpty()) {
        return;
    }
        int in = StdIn.readInt();
        String[] list = new String[in];
        for (int i = 0; i < in; i++) {
            String s = StdIn.readString();
            list[i] = s;
        }
        int ip = StdIn.readInt();
    

    for (int j = 0; j < ip; j++) {
        if (!StdIn.isEmpty()) {
        String c = StdIn.readString();
        if (!StdIn.isEmpty()) {
        String insert = StdIn.readString();
        for (int k = 0; k < list.length; k++) {
            int x = list[k].indexOf(" ");
            String c1 = new String();
            if (x != -1) {
                c1 = list[k].substring(0,x);
            } else {
                c1 = list[k];
            }

            if (c1.compareTo(c) == 0) {
                list[k] += " ";
                list[k] += insert;
            }
        }
        }
    }
    }


    StdIn.setFile(args[1]);
    String o = StdIn.readString();
    int oint = StdIn.readInt();
    ArrayList<String> tk = new ArrayList<>();
    for (int i = 0; i < oint; i++) {
        tk.add(StdIn.readString());
    }

    int z = tk.size();
    for (int r = 0; r < z; r++) {
        ArrayList<String> finish = new ArrayList<>();
        finish.add(tk.get(r));
        for (int i = 0; i < finish.size(); i++) {
        for (int j = 0; j < list.length; j++) {
            if (finish.get(i).compareTo(PRcheck(list[j])) == 0) {
                shortl(list[j], finish);
            }
        }
    }

    ArrayList<String> t1 = new ArrayList<>();
    for (int m = 1; m < finish.size(); m++) {
        int c3 = 0;
    for (int q = 0; q < tk.size(); q++) {
        if (finish.get(m).compareTo(tk.get(q)) == 0) {
            c3 = 1;
            break;
        }
    }
    if (c3 == 0) {
        t1.add(finish.get(m));
    }

    }
    if (t1.size() > 0) {
      for (int g = 0; g < t1.size(); g++)
         tk.add(t1.get(g));
      }

    }

    ArrayList<String> t2 = new ArrayList<>();
    t2.add(o);

    for (int i = 0; i < t2.size(); i++) {
        for (int j = 0; j < list.length; j++) {
            if (t2.get(i).compareTo(PRcheck(list[j])) == 0) {
                shortl(list[j], t2);
            }
        }
    }

    StdOut.setFile(args[2]);

    for (int i = 1; i < t2.size(); i++) {
        int d = 0;
        for (int j = 0; j < tk.size(); j++) {
            if (t2.get(i).compareTo(tk.get(j)) == 0) {
                d = 1;
                break;
            }
        }
        if (d == 0) {
            StdOut.println(t2.get(i));
        }
    }
}
}
