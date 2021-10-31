package Level1;

import java.util.Arrays;

public class Marathon {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        if(completion.length==0) {
            return answer;
        }
        Arrays.sort(participant);
        Arrays.sort(completion);
        for(int i=0; i<completion.length; i++) {
            if(participant[i].equals(completion[i])) {
                continue;
            } else {
                answer=participant[i];
                break;
            }
        }
        if(answer.equals("")) {
            answer=participant[participant.length-1];
        }
        return answer;
    }
}
