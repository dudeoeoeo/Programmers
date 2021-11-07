package weekly;

import java.util.*;

public class Weekly9 {
    ArrayList<Integer>[] arr;
    int N;
    HashMap<Integer, ArrayList<Integer>> map;
    ArrayList<Integer> list;
    int idx;
    public int solution(int n, int[][] wires) {
        idx = 0;
        N = n;
        map = new HashMap<>();
        for (int i = 0; i < n + 1; i++)
            map.put(i, new ArrayList<>());

        for (int i = 0; i < wires.length; i++) {
            int f_node = wires[i][0];
            int s_node = wires[i][1];

            if(!map.get(f_node).contains(s_node))
                map.get(f_node).add(s_node);
            if(!map.get(s_node).contains(f_node))
                map.get(s_node).add(f_node);
        }
        boolean bool = true;
        int size = map.get(1).size();
        for (int i = 1; i < map.size(); i++) {
            Collections.sort(map.get(i));
            System.out.println("idx: "+idx+", size: "+map.get(i).size());
            if(size < map.get(i).size()) {
                size = Math.max(size, map.get(i).size());
                idx = i;
                bool = false;
            }
        }
        if(bool) return 0;
        System.out.println("map: "+map.toString() + ", idx: "+idx);

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> temp = map.get(idx);
        int answer = 100;
        for (int i = 0; i < temp.size(); i++) {
            queue.offer(temp.get(i));
            list = new ArrayList<>();
            list.add(temp.get(i));
            bfs(queue);
            System.out.println("list size: "+list.size());
            answer = Math.min(answer, Math.abs(n - list.size() - list.size()));
        }
        return answer;
    }
    void bfs(Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            ArrayList<Integer> node = map.get(queue.poll());

            for (int i = 0; i < node.size(); i++) {
                int now = node.get(i);
                if(now != idx && !list.contains(now)) {
                    queue.offer(now);
                    list.add(now);
                }
                if (list.size() == N / 2) return;
            }
        }
    }
//    public int solution(int n, int[][] wires) {
//        int max = Integer.MIN_VALUE;
//        int min = Integer.MIN_VALUE;
//        N = n;
//        arr = new ArrayList[n + 1];
//        for(int i = 0; i < n + 1; i++)
//            arr[i] = new ArrayList<>();
//
//        for (int i = 0; i < wires.length; i++) {
//            int f_node = wires[i][0];
//            int s_node = wires[i][1];
//            if(!arr[f_node].contains(s_node))
//                arr[f_node].add(s_node);
//            if(!arr[s_node].contains(f_node))
//                arr[s_node].add(f_node);
//        }
//
//        int idx = 0;
//        for (ArrayList<Integer> a : arr) {
//            System.out.println("a: "+a.toString());
//            if(Math.ceil((double) n / 2) == a.size()) {
//                System.out.println("n / 2: "+Math.ceil((double) n/2)+", a.size(): "+a.size());
//                return 0;
//            }
//            System.out.println("max: "+max+", a.size(): "+a.size());
//            if(max < a.size()) {
//                max = a.size();
//                answer = idx;
//            }
//            idx++;
//        }
//        System.out.println("answer: "+answer);
//        int ans = 100;
//        for(int i = 0; i < arr[answer].size(); i++) {
//            int node = arr[answer].get(i);
//            list = new ArrayList<Integer>();
//            list.add(node);
//            dfs(node);
//            min = list.size();
//            int temp = n - min;
//            ans = Math.min(ans, Math.abs(temp - min));
//        }
//
//        return ans;
//    }
//    void dfs(int node) {
//        //System.out.println("arr[node]: "+arr[node].toString());
//        for(int i = 0; i < arr[node].size(); i++) {
//            int curr = arr[node].get(i);
//            //System.out.println("answer: "+answer+", curr: "+curr);
//            //System.out.println("list: "+list.toString());
//            if(answer != curr && !list.contains(curr)) {
//                System.out.println("curr: "+curr);
//                list.add(curr);
//                dfs(curr);
//            }
//        }
//    }
    public static void main(String[] args) {
        //int [][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        //int [][] wires = {{1,2},{2,3},{3,4}};
        int [][][] wires = {{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}, {{1,2},{2,3},{3,4}}, {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}}, {{1,2},{3,2}}, {{1,2},{1,3},{1,4},{4,5},{5,6},{6,7},{6,8}}};
        int [] n = {9,4,7,3,8};
        Weekly9 w9 = new Weekly9();
        int idx = 0;
        for (int [][] wire : wires) {
            System.out.println(w9.solution(n[idx], wire));
            idx++;
            System.out.println("===============================================================================");
        }
    }
}
