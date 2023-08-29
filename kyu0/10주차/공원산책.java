import java.util.*;

class Solution {
    private int w;
    private int h;
    private int x;
    private int y;
    private String[] park;

    // 초기화 함수
    private void initialize(String[] park) {
        w = park[0].length();
        h = park.length;
        this.park = park;
        
        for (int i = 0 ; i < h ; i++) {
            for (int j = 0 ; j < w ; j++) {
                if (park[i].charAt(j) == 'S') {
                    y = i;
                    x = j;
                    return;
                }
            }
        }
    }
  
    private boolean isInside(int cy, int cx) {
        return cx >= 0 && cx < w && cy >= 0 && cy < h;
    }

    // 방향에 맞게 이동
    private void move(String route) {
        char direction = route.charAt(0);
        int steps = Integer.parseInt(route.substring(2));
        int dx=0, dy=0;
        
        switch (direction) {
            case 'N':
                dy=-1;
            break;
            case 'E':
                dx=1;
            break;
            case 'W':
                dx=-1;
            break;
            case 'S':
                dy=1;
            break;
        }
        
        int tempY = this.y, tempX = this.x;
        for (int i = 0 ; i < steps ; i++) {
            tempY += dy;
            tempX += dx;
            if (!isInside(tempY, tempX) || park[tempY].charAt(tempX) == 'X') return;
        }
        
        y = tempY;
        x = tempX;
    }
    
    public int[] solution(String[] park, String[] routes) {
        int answer[] = new int[2];
        
        initialize(park);
        
        for (String route : routes) {
            move(route);
        }
        
        answer[0] = y;
        answer[1] = x;
        
        return answer;
    }
}
