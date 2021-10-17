package dev_matching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Pyramid {

    HashMap<String, ArrayList<String>> map = new HashMap<>();
    HashMap<String, String> ancestor = new HashMap<>();
    HashMap<String, Integer> earnMoney = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        int len = enroll.length;

        for (int i = 0; i < len; i++) {
            map.put(enroll[i], new ArrayList<>());
            earnMoney.put(enroll[i], 0);
            if(referral[i].equals("-")) {
                ancestor.put(enroll[i], "-");
                continue;
            }
            map.get(referral[i]).add(enroll[i]);
            ancestor.put(enroll[i], referral[i]);
        }

        len = seller.length;
        for(int i = 0; i < len; i++)
            dfs(amount[i] * 100, seller[i]);

        int[] answer = new int[enroll.length];
        int idx = 0;
        for (String en : enroll) {
            answer[idx] = earnMoney.get(en);
            idx++;
        }
        return answer;
    }

    void dfs(int money, String name) {

        if((double) money / 10 < 1) {
            earnMoney.put(name, (int) (earnMoney.get(name) + money));
            return;
        }

        earnMoney.put(name, (int) (earnMoney.get(name) + (money - (money / 10))));

        if(!ancestor.get(name).isEmpty() && !ancestor.get(name).equals("-"))
            dfs((money / 10), ancestor.get(name));
    }

    public static void main(String[] args) {
        Pyramid p = new Pyramid();
        String [] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String [] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String [] seller = {"young", "john", "tod", "emily", "mary"};
        int [] amount = {12, 4, 2, 5, 10};
        System.out.println(Arrays.toString(p.solution(enroll, referral, seller, amount)));
    }
}
