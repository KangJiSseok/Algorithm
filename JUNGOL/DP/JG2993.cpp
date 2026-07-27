#include <iostream>
#include <algorithm>
#define INF 1e9

using namespace std;

bool arr[200];
int dp[200][200];

int N, M;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    fill(&dp[0][0], &dp[0][0] + 200 * 200, INF);

    cin >> N >> M;
    for(int i = 1; i <= M; i++ ){
        int a;
        cin >> a;
        arr[a] = true;
    }

    // for(int i = 0; i < 200; i++){
    //     dp[0][i] = 0;
    // }

    dp[0][0] = 0;
    for(int i = 0; i <= N; i++){
        
        for(int j = 0; j < 100; j++){
            if(arr[i + 1]){
                dp[i + 1][j] = min(dp[i + 1][j], dp[i][j]);
            }

            dp[i + 1][j] = min(dp[i + 1][j], dp[i][j] + 10000);
            dp[i + 3][j] = min(dp[i + 3][j], dp[i][j] + 25000);
            dp[i + 5][j] = min(dp[i + 5][j], dp[i][j] + 37000);
            
            dp[i + 3][j + 1] = min(dp[i + 3][j + 1], dp[i][j] + 25000);
            dp[i + 5][j + 2] = min(dp[i + 5][j + 2], dp[i][j] + 37000);

            if(j >= 3){
                dp[i + 1][j - 3] = min(dp[i + 1][j - 3], dp[i][j]);
            }
        }

    }
    /**
     * 0    1   2   3   4   5   6   7   8   9   10  11  12  13
     * 0    100 200 250 350 370 470 570 720
     * 1            250 350 450    
     * 2                    370 470 570
     * 3
     */

    int result = INF;
    for(int i = 0; i < 200; i++){
        result = min(result, dp[N][i]);
    }

    cout << result;

}