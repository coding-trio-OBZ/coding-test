import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] food) {
        String answer = "";

        Deque<Integer> table = new ArrayDeque<>();
        table.add(0);

        for (int i = food.length - 1 ; i >= 0 ; i--) {
            int size = food[i] / 2;
            for (int j = 0 ; j < size ; j++) {
                table.addFirst(i);
                table.addLast(i);
            }
        }

        answer = table.stream().map(e -> Integer.toString(e))
            .collect(Collectors.joining());

        return answer;
    }
}