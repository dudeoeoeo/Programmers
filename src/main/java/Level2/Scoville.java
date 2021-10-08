package Level2;

import java.util.PriorityQueue;

public class Scoville {

    public int solution(int[] scoville, int K) {
        int answer = 0;
        int min = 0;
        int second = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int scov : scoville)
            pq.offer(scov);

        while (!pq.isEmpty()) {
            if(pq.peek() >= K)
                break;
            if(pq.size() <= 1)
                break;
            answer++;

            min = pq.poll();
            second = pq.poll();

            pq.add(min + (second * 2));
        }
        if(pq.isEmpty())
            return -1;
        else if(pq.size() == 1 && pq.peek() < K)
            return -1;

        return answer;
    }

    public static void main(String[] args) {

        int [][] scoville = {{1,2,3,9,10,12}, {0, 0}, {1,2}, {1,2,3}, {7, 1}, {3, 4}, {4, 4}, {3, 3}, {1,5}, {2,3,7,10,15}};
        int K = 7;
        Scoville sco = new Scoville();
        for (int [] socvill : scoville) {
            System.out.println(sco.solution(socvill, K));
        }
    }
}
