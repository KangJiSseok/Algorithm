#include <iostream>
using namespace std;

int profit[301][21];
int dp[301][21];
int choice[301][21];
int amt[301];

int N, M;
int main(){
    cin >> N >> M;
    for(int k = 1; k <= N; k++){
        int j;
        cin >> j;
        for(int i = 1; i <= M; i++){
            cin >> profit[i][j];
        }
    }
    for(int i = 1; i <= M; i++){
        for(int j = 0; j <= N; j++){
            int best = -1, bk = 0;
            for(int k = 0; k <= j; k++){
                int val = dp[i - 1][j - k] + profit[i][k];
                if(val > best){ 
                    best=val; 
                    bk=k; 
                }
            }
            dp[i][j]=best;
            choice[i][j]=bk;
        }
    }

    cout << dp[M][N] << "\n";

    int j = N;
    for(int i = M; i >= 1; i--){
        int k = choice[i][j];
        amt[i] = k;
        j -= k;
    }

    for(int i = 1; i <= M; i++){
        cout << amt[i] << " ";
    }
}