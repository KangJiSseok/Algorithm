#include <string>
#include <vector>
#include <climits>
#include <algorithm>

const int INF = 1e9;
using namespace std;

int solution(vector<vector<int>> info, int n, int m) {
    int len = info.size();

    vector<vector<int>> dp(len + 1, vector<int>(n + 1, INF));
    dp[0][0] = 0;

    for(int i = 1; i<= len; i++){
        int a = info[i - 1][0];
        int b = info[i - 1][1];
        for(int j = 0; j < n; j++){
            if(dp[i - 1][j] + b < m) dp[i][j] = min(dp[i][j], dp[i - 1][j] + b);
            if(j + a < n) dp[i][j + a] = min(dp[i][j + a], dp[i - 1][j]);
        }
    }

    for(int j = 0; j < n; j++) if(dp[len][j] < INF) return j;
    return -1;
}