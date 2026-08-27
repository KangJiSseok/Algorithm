#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int arr[2][n + 1];
    fill(&arr[0][0], &arr[0][0] + 2 * (n + 1), 1);

    for(int i = 0; i < lost.size(); i++){
        arr[0][lost[i]] = 0;
    }

    sort(lost.begin(), lost.end());
    sort(reserve.begin(), reserve.end());

    for(int i = 0; i < reserve.size(); i++){
        if(find(lost.begin(), lost.end(), reserve[i]) != lost.end()){
            arr[1][reserve[i]] = 0;
            arr[0][reserve[i]] = 1;
        }else{
            if(arr[1][reserve[i]] == 1 && (reserve[i] - 1 >= 1) && arr[0][reserve[i] - 1] == 0){
                arr[1][reserve[i]] = 0;
                arr[0][reserve[i] - 1] = 1;
            }
            if(arr[1][reserve[i]] == 1 && (reserve[i] + 1) <= n && arr[0][reserve[i] + 1] == 0){
                arr[1][reserve[i]] = 0;
                arr[0][reserve[i] + 1] = 1;
            }
        }
    }

    int cnt = 0;
    for(int i = 1; i<= n; i++){
        if(arr[0][i] == 1) cnt++;
    }

    return cnt;
}
