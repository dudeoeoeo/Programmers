package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class DFSSearch {

    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
        graph.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
        graph.put("B", new ArrayList<String>(Arrays.asList("A", "D")));
        graph.put("C", new ArrayList<String>(Arrays.asList("A", "G", "H", "I")));
        graph.put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
        graph.put("E", new ArrayList<String>(Arrays.asList("D")));
        graph.put("F", new ArrayList<String>(Arrays.asList("D")));
        graph.put("G", new ArrayList<String>(Arrays.asList("C")));
        graph.put("H", new ArrayList<String>(Arrays.asList("C")));
        graph.put("I", new ArrayList<String>(Arrays.asList("C", "J")));
        graph.put("J", new ArrayList<String>(Arrays.asList("I")));

        DFSSearch t = new DFSSearch();
        ArrayList<String> dfs = t.dfsFunc(graph, "A");
        System.out.println(dfs.toString());
    }

    public ArrayList<String> dfsFunc(HashMap<String, ArrayList<String>> graph, String startNode) {
        ArrayList<String> visited = new ArrayList<>();
        Stack<String> needVisitStack = new Stack<>();

        needVisitStack.add(startNode);

        while(!needVisitStack.isEmpty()) {
            String curr = needVisitStack.pop();

            if(!visited.contains(curr)) {
                visited.add(curr);
                needVisitStack.addAll(graph.get(curr));
            }
        }
        return visited;
    }
}
