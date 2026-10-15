#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> sticker)
{
    int answer =0;

    int n = sticker.size();

    if(n == 1) return sticker[0];
    if(n == 2) return max(sticker[0], sticker[1]);

    int dp[n];

    //1. 마지막 원소 제외
    dp[0] = sticker[0];
    dp[1] = max(sticker[0], sticker[1]);

    for(int i = 2; i < sticker.size() - 1; i++){
        dp[i] = max(dp[i - 1], dp[i - 2] + sticker[i]);
    }

    answer = dp[n - 2];

    //2. 첫번째 원소 제외
    dp[0] = 0;
    dp[1] = sticker[1];

    for(int i = 2 ; i< sticker.size(); i++){
        dp[i] = max(dp[i - 1], dp[i - 2] + sticker[i]);
    }

    answer = max(answer, dp[n - 1]);
    return answer;
}