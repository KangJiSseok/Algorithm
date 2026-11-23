#include <iostream>
#include <vector>
#include <queue>

using namespace std;

//dp[a][b] = a를 만드는데 b가 c개 필요하다.
int dp[101][101];
int N, M;
vector<pair<int, int>> graph[101];
int degree[101];

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N;
    cin >> M;
    for(int i = 0; i < M; i++){
        int x, y, k;
        cin >> x >> y >> k;
        degree[x]++;
        graph[y].push_back({x, k});
    }


    vector<int> s;
    vector<int> q;
    for(int i = 1; i <= N; i++){
        if(degree[i] == 0) {
            q.push_back(i);
            s.push_back(i);
            dp[i][i] = 1;
        }
    }

    while(!q.empty()){
        int x = q.back(); q.pop_back();

        for(auto[y, k] : graph[x]){
            for(int c : s){
                dp[y][c] += dp[x][c] * k;
            }

            degree[y]--;

            if(degree[y] == 0) q.push_back(y);
        }
    }

    for(int x : s){
        cout << x << " " << dp[N][x] << "\n";
    }



}

/**
 * X Y K
 * X 를 만드는데 Y가 K개 필요
 */