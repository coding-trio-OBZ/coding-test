import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = {};

        List<Integer> rank = new ArrayList<>(), presentation = new ArrayList<>();

        // 원소가 추가될 때마다 정렬을 수행하므로 시간 복잡도: O(sigma (A=from 1 to N) AlogA ≈ 그래프 보면 대충 N^2 정도 되는듯)
        // Deque, 조건문 써서 요래조래하면 O(N)에 계산할 수 있음.
        for (int s : score) {
            rank.add(s);
            rank.sort(Comparator.reverseOrder());

            int temp = 0;
            for (int i = 0 ; i < k && i < rank.size() ; i++) {
                temp = rank.get(i);
            }

            presentation.add(temp);
        }

        answer = presentation.stream().mapToInt(i -> i).toArray();

        return answer;
    }
}