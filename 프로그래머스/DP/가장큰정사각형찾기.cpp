#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

int dp[1001][1001];

int solution(vector<vector<int>> board){
    int N = board.size(), M = board[0].size();
    int MAX = 0;

    for(int i = 1; i <= N; i++){
        for(int j = 1; j <= M; j++){
            if(board[i-1][j-1] == 1){
                dp[i][j] = min({dp[i-1][j], dp[i][j-1], dp[i-1][j-1]}) + 1;
                MAX = max(MAX, dp[i][j]);
            } else {
                dp[i][j] = 0;
            }
        }
    }
    return MAX * MAX;
}