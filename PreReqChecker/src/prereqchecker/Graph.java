package prereqchecker;
import java.util.*;


public class Graph {
    HashMap<String, ArrayList<String>> listc = new HashMap<String, ArrayList<String>>();

    public Graph(String inputFile){
        StdIn.setFile(inputFile);
        int n1 = StdIn.readInt();
        String r = StdIn.readLine();
        for(int i=0;i<n1;i++){
            String name = StdIn.readLine();
            ArrayList <String> list = new ArrayList<>();
            listc.put(name,list);
        }
        int n2 = StdIn.readInt();
        String m = StdIn.readLine();
        for(int i =0;i<n2;i++){
            String d = StdIn.readLine();
            String [] store = d.split(" ");
            ArrayList <String> L = listc.get(store[0]);
            L.add(store[1]);
            listc.put(store[0],L);
        }
        return;
       

       
    }
    public boolean Cycle(String v, String d){
        if(v.equals(d)){
            return true;
        }
        ArrayList<String> cl = listc.get(v);
        for(int i =0; i<cl.size();i++){
            String req = cl.get(i);
            if(Cycle(req,d)){
                return true;
            }
        }
        return false;
    }
}
