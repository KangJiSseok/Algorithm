#include <iostream>
#include <queue>

using namespace std;

int N, M;
int R , C, S, K;
int map[101][101];
int visited[101][101];
int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};
int dx[] = {-2, -1, 1, 2, 2, 1, -1, -2};

bool isRange(int y, int x){
    return 1 <= y && y <= N && 1 <= x && x <= M;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> M;
    cin >> R >> C >> S >> K;

    fill(&visited[0][0], &visited[0][0] + 101 * 101, -1);

    queue<pair<int, int>> q;
    q.push({R, C});
    visited[R][C] = 0;

    while(!q.empty()){
        auto[y, x] = q.front();

        q.pop();
        if(y == S && x == K) break;

        for(int d = 0; d< 8; d++){
            int ny = y + dy[d];
            int nx = x + dx[d];
            if(isRange(ny, nx) && visited[ny][nx] == -1){
                q.push({ny, nx});
                visited[ny][nx] = visited[y][x] + 1;
            }
        }
    }

    cout << visited[S][K];
}
