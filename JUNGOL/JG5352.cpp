#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int T, N, K;
char map[51][51];
int dp[51][51][4][2];
int dy[] = {0, 1};
int dx[] = {1, 0};

bool isRange(int y, int x){
    return 1 <= y && y <= N && 1 <= x && x <= N;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> T;

    while(T-- > 0){
        fill(&dp[0][0][0][0], &dp[0][0][0][0] + 51 * 51 * 4 * 2, 0);
        cin >> N >> K;
        for(int i =1; i <= N; i++){
            string str;
            cin >> str;
            for(int j =1; j<= N; j++){
                map[i][j] = str[j - 1];
            }
        }

        if(map[1][2] != 'H') dp[1][2][0][0] = 1;
        if(map[2][1] != 'H') dp[2][1][0][1] = 1; 
    
        for(int y = 1; y <= N; y++){
            for(int x = 1; x <= N; x++){
                for(int cnt =0; cnt <= K; cnt++){
                    for(int dir = 0; dir < 2; dir++){
                        for(int nDir = 0; nDir < 2; nDir++){
                            int ny = y + dy[nDir];
                            int nx = x + dx[nDir];
                            int nextCnt = cnt + (dir != nDir);
                            
                            if(!isRange(ny, nx)) continue;
                            if(map[ny][nx] == 'H') continue;
                            if(nextCnt > K) continue;

                            dp[ny][nx][nextCnt][nDir] += dp[y][x][cnt][dir];
                        }
                    }
                }
            }
        }

        int answer = 0;
        for(int cnt =0; cnt <= K; cnt++){
            answer += dp[N][N][cnt][0] + dp[N][N][cnt][1];
        }

        cout << answer << "\n";

    }



}