#include <string>
#include <vector>
#include <queue>


using namespace std;

int dy[] = {-1, 0, 0, 1};
int dx[] = {0, -1, 1, 0};
int N, M;

int bfs(vector<vector<int>> &visited, int sy, int sx, int ey, int ex, vector<string> &maps){
    
    queue<pair<int, int>> q;
    q.push({sy, sx});
    visited[sy][sx] = 0;

    while(!q.empty()){
        auto[y, x] = q.front(); q.pop();

        if(y == ey && x == ex) break;

        for(int d = 0; d < 4; d++){
            int ny = y + dy[d];
            int nx = x + dx[d];
            if(0 <= ny && ny < N && 0 <= nx && nx < M){
                if(visited[ny][nx] == -1 && maps[ny][nx] != 'X'){
                    q.push({ny, nx});
                    visited[ny][nx] = visited[y][x] + 1;
                }
            }
        }
    }

    return visited[ey][ex];
}

int solution(vector<string> maps) {
    int answer = 0;
    
    N = maps.size();
    M = maps[0].size();

    int sy, sx ,ly, lx, ey, ex;

    for(int i =0; i < N; i++){
        for(int j = 0; j < M; j++){
            if(maps[i][j] == 'S'){
                sy = i;
                sx = j;
            }else if(maps[i][j] == 'L'){
                ly = i;
                lx = j;
            }else if(maps[i][j] == 'E'){
                ey = i;
                ex = j;
            }
        }
    }


    vector<vector<int>> visited1(N, vector<int>(M, -1));
    vector<vector<int>> visited2(N, vector<int>(M, -1));

    int a = bfs(visited1, sy, sx, ly, lx, maps);
    int b = bfs(visited2, ly, lx, ey, ex, maps);

    answer = ((a != -1) && (b != -1)) ? a + b : -1;
    
    return answer;
}