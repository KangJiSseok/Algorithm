#include <string>
#include <vector>
#include <iostream>

using namespace std;

int dp[101][100'001];
const int MOD = 1'000'000'007;

int solution(int n, vector<int> money) {

    for(int i = 0; i <= money.size(); i++){
        dp[i][0] = 1;
    }

    for(int i = 1; i <= money.size(); i++){
        int m = money[i - 1];

        for(int j = 1; j <= n; j++){

            dp[i][j] = dp[i - 1][j];

            if(j >= m){
                dp[i][j] += dp[i][j - m];
                dp[i][j] %= MOD;
            }
        }
    }

    return dp[money.size()][n];
}