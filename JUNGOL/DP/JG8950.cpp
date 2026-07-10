#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
#include <stack>

using namespace std;

int N, M;
vector<pair<int, int>> arr;
int dp[5001][5001];

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> N >> M;

    arr.push_back({0,0});
    for(int i=0; i< N; i++){
        int a, b;
        cin >> a >> b;
        arr.push_back({a, b});
    }


    for(int i= 1; i<= N; i++){
        for(int j = 1; j <= M; j++){
            dp[i][j] = dp[i - 1][j];
            if(j >= arr[i].second){
                dp[i][j] = max(dp[i][j], dp[i - 1][j - arr[i].second] + arr[i].first);
            }
        }
    }

    cout << dp[N][M];

    for(int i=1; i<= N; i++){
        cout << "\n";
        for(int j=1; j<=M; j++){
            cout << dp[i][j] << "       ";
        }
    }

    if(dp[N][M] == 0){
        cout << -1;
        exit(0);
    }

    stack<int> result;
    int i = N, j = M;
    while(i > 0){
        //사용한것
        if(dp[i][j] != dp[i - 1][j]){
            result.push(i);
            j -= arr[i].second;
        }
        i--;
    }

    cout << result.size() << "\n";
    while(!result.empty()) {
        cout << result.top() << " ";
        result.pop();
    }
}

/**
 * 0    1   2   3   4   5   6   7   8   9   10  11  12  13
 * 1    1   1   1   1   1   1   1   1   1   1   1   1   1
 * 2    1   1   9   10  10  10  10  10  10  10  10  10  10
 * 3    1   18  19  19    
 * 4
 * 5
 * 6
 * 7
 * 8
 * 
 */