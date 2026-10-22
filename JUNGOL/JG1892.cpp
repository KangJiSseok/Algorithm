#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int dy[] = {-1,0,0,1};
int dx[] = {0,-1,1,0};

int N, M;
int map[101][101];
int dp[101][101];


struct Node{
    int y, x, num;
};

struct Comp{
    bool operator()(const Node &a, const Node &b){
        return a.num < b.num;
    }
};

void dfs(int y, int x){

    for(int d = 0; d < 4; d++){
        int ny = y + dy[d];
        int nx = x + dx[d];

        if(ny <= 0 || ny > N || nx <= 0 || nx > M) continue;
        if(map[y][x] >= map[ny][nx]) continue;
        if(dp[ny][nx] < dp[y][x] + 1){
            dp[ny][nx] = dp[y][x] + 1;
            dfs(ny, nx);
        }
    }

}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> M;

    vector<Node> list;

    for(int i = 1; i<= N; i++){
        for(int j = 1; j <= M; j++){
            int a;
            cin >> a;
            map[i][j] = a;
            list.push_back({i, j, a});
        }
    }

    fill(&dp[0][0], &dp[0][0] + 101 * 101, -1);


    //정렬 후 작은 좌표부터 차례대로 방문하기.

    sort(list.begin(), list.end(), Comp{});

    for(Node node : list){
        int y = node.y;
        int x = node.x;
        if(dp[y][x] == -1){
            dp[y][x] = 1;
            dfs(y, x);
        }
    }

    int MAX = -1;
    for(int i =1; i<= N; i++){
        for(int j = 1; j <= M; j++){
            MAX = max(MAX, dp[i][j]);
        }
    }

    cout << MAX;
}