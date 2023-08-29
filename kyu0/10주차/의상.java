import java.util.*;

class Solution {
    // key: type, value: clothes
    private Map<String, List<String>> clothesDict = new HashMap<>();
    
    public int solution(String[][] clothes) {
        int answer = 1;

        // 의상 타입별로 Map에 저장
        for (String[] clothe : clothes) {
            String wear = clothe[0], type = clothe[1];
            
            List<String> savedClothes = clothesDict.get(type);
            if (savedClothes == null) {
                savedClothes = new ArrayList<>();
                clothesDict.put(type, savedClothes);
            }
            
            savedClothes.add(wear);
        }
        
        Iterator<String> typeIterator = clothesDict.keySet().iterator();

        // 타입 순회하면서 조합 구하기
        while (typeIterator.hasNext()) {
            String type = typeIterator.next();
            
            answer *= clothesDict.get(type).size() + 1; // 해당 타입의 옷을 안 입는 것까지 고려
        }

        // 전부 안입는 경우는 빼자
        answer -= 1;
        
        return answer;
    }
}
