#include <string>
#include <vector>
#include <queue>
#include <unordered_set>
#include <unordered_map>
#include <algorithm>
#include <iostream>

using namespace std;

int idx = 0;
int dy[4] = {-1,0,0,1};
int dx[4] = {0,-1,1,0};

int idxArr[500][500];
bool visited[500][500];

int N, M;
int MAX = 0;
unordered_set<int> u_set;
unordered_map<int, int> u_map;

bool isRange(int y, int x){
    return 0 <= y && y < N && 0 <=x && x < M;
}

void bfs(int y, int x, vector<vector<int>> &land){
    int cnt = 0;
    idx++;
    queue<pair<int, int>> q;
    q.push({y, x});
    visited[y][x] = true;

    while(!q.empty()){
        auto[a, b] = q.front();
        q.pop();
        cnt++;
        idxArr[a][b] = idx;
        for(int d= 0; d < 4; d++){
            int ny = a + dy[d];
            int nx = b + dx[d];
            if(isRange(ny, nx) && land[ny][nx] == 1 && !visited[ny][nx]){
                visited[ny][nx] = true;
                q.push({ny, nx});
            }
        }
    }
    u_map[idx] = cnt;
}

int findCnt(int x, vector<vector<int>> &land){
    int sum = 0;

    u_set.clear();
    for(int i =0; i< N; i++){
        if(land[i][x] == 1){
            int idx = idxArr[i][x];
            if(u_set.find(idx) == u_set.end()){
                u_set.insert(idx);
                sum += u_map[idx];
            }
        }
    }

    return sum;
}

int solution(vector<vector<int>> land) {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    N = land.size();
    M = land[0].size();

    for(int i =0; i< N; i++){
        for(int j =0; j < M; j++){
            if(land[i][j] == 1 && !visited[i][j]){
                bfs(i, j, land);
            }
        }
    }

    for(int i = 0; i < M; i++){
        int sum = findCnt(i, land);
        MAX = max(MAX, sum);
    }


    // for(int i =0 ; i< N; i++){
    //     cout << "\n";
    //     for(int j = 0; j < M; j++){
    //         cout << idxArr[i][j] << " ";
    //     }
    // }


    return MAX;
}