#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N, K1, K2;
vector<pair<int,int>> arr;
vector<int> pos;
vector<vector<int>> school;
vector<int> result;

int find(vector<int>& v, int lo, int hi) {
    auto l = lower_bound(v.begin(), v.end(), lo);
    auto r = upper_bound(v.begin(), v.end(), hi);
    return r - l;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N >> K1 >> K2;
    
    school.resize(N + 1);
    for (int i = 0; i < N; i++) {
        int a, b;
        cin >> a >> b;
        arr.push_back({a, b});
        pos.push_back(a);
        school[b].push_back(a);
    }


    sort(pos.begin(), pos.end());
    for (int s = 0; s < N; s++) {
        sort(school[s].begin(), school[s].end());
    }

    for (int i = 0; i < N; i++) {
        int x = arr[i].first;
        int s = arr[i].second;

        // K2 아래에 있는 모든 친구 개수 
        int totalK2 = find(pos, x - K2, x + K2) - 1;
        // 같은 학교면서, K1 거리 안에 있는 친구 개수
        int sameK1  = find(school[s], x - K1, x + K1) - 1;  
        // 같은 학교면서, K2 거리 안에 있는 친구 개수
        int sameK2  = find(school[s], x - K2, x + K2) - 1;

        //totalK2 - sameK2 = 다른 학교면서 K2 거리 안에 있는 친구 개수
        result.push_back(sameK1 + totalK2 - sameK2);
    }

    for (int i = 0; i < N; i++) {
        cout << result[i] << " ";
    }
    cout << "\n";
}