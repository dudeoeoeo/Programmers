package Level1;

import java.util.Arrays;

public class Budget {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int bg : d) {
            budget -= bg;
            if(budget >= 0)
                answer++;
            else
                break;
        }
        return answer;
    }
}
