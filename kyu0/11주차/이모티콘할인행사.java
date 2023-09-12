import java.util.*;

class Solution {
    // field 선언
    private final int[] SALE_RATES = {10, 20, 30, 40};
    
    private List<Integer> saled = new ArrayList<>();
    private int maxMember = 0;
    private int maxPrice = 0;
    
    // price에 (sale)% 할인이면 얼마인지 반환하는 함수
    private int getSalePrice(int price, int sale) {
        return (int)(price * (100 - sale) / 100);
    }
    
    // 이모티콘의 가격 emoticons가 주어질 때, 각 유저가 지불한 금액을 반환함
    private int[] getUserPurchase(int[] user, int[] emoticons) {
        int saleThreshold = user[0], priceThreshold = user[1];
        int[] temp = {1, 0};
        
        for (int i = 0 ; i < emoticons.length ; i++) {
            if (saleThreshold <= saled.get(i)) {
                temp[1] += getSalePrice(emoticons[i], saled.get(i));
            }
        }
        
        if (temp[1] >= priceThreshold) {
            temp[1] = 0;
            return temp;
        }
        else {
            temp[0] = 0;
            return temp;
        }
    }
    
    // 최고 매출액을 구하는 메소드
    private void getResult(int[][] users, int[] emoticons) {
        int tempMember = 0, tempPrice = 0;
        
        for (int[] user : users) {
            int[] result = getUserPurchase(user, emoticons);
            tempMember += result[0];
            tempPrice += result[1];
        }
        
        if (tempMember > maxMember) {
            maxMember = tempMember;
            maxPrice = tempPrice;
        }
        else if (tempMember == maxMember && tempPrice > maxPrice) {
            maxPrice = tempPrice;
        }
    }
    
    // 할인의 경우의 수를 다 따지는 DFS 메소드
    private void dfs(int[][] users, int[] emoticons) {
        if (saled.size() == emoticons.length) {
            getResult(users, emoticons);
            return;
        }
        
        for (int SALE_RATE : SALE_RATES) {
            saled.add(SALE_RATE);
            dfs(users, emoticons);
            saled.remove(saled.size() - 1);
        }
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        
        dfs(users, emoticons);
        
        answer[0] = maxMember;
        answer[1] = maxPrice;
        
        return answer;
    }
}