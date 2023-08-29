#include <string>
#include <vector>
#include <cmath>

using namespace std;

vector<int> getOrder(vector<int> list, long long k) {
    vector<int> result;

    k--; // 계산 편의상 k - 1 연산
    
    // 규칙을 찾아내서 효율적으로 k번 째 순열 구하기
    /*
     ex, n = 4일 때
     1, 2, 3, 4
     1, 2, 4, 3
     1, 3, 2, 4
     1, 3, 4, 2
     1, 4, 2, 3
     1, 4, 3, 2 -> 여기까지 1이 처음 숫자로 6번 = 3 * 2 * 1 = (n-1)! 등장
     2, 1, 3, 4
     ...
     -> 모든 n에 대해서 첫번째 숫자는 (n-1)! 번 반복적으로 나옴
     등장한 숫자를 제외하면 나머지 숫자 집합에 대해서도 똑같은 규칙이 적용되기 때문에
     같은 로직을 반복해 우리가 구하고자 하는 순열을 구한다.
    */
    while (!list.empty()) {
        long long div = 1;
        for (int i = list.size() - 1 ; i > 0 ; i--) {
            div *= i;
        }

        int position = floor((double)k / div);
        
        result.push_back(list[position]);
        list.erase(list.begin() + position);

        k = k % div;
    }

    return result;
}

vector<int> solution(int n, long long k) {
    vector<int> answer;

    vector<int> list;

    for (int i = 1 ; i <= n ; i++) {
        list.push_back(i);
    }

    answer = getOrder(list, k);

    return answer;
}
