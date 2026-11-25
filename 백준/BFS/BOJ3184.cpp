#include <iostream>
#include <queue>

using namespace std;

int N, M;
char arr[251][251];
int visited[251][251];
queue<pair<int, int>> q;
int W = 0, S = 0;

int dy[4] = {0, -1, 1, 0};
int dx[4] = {-1, 0, 0, 1};

bool isRange(int y, int x){
    return 1 <= y && y <= N && 1 <= x && x <= M;
}


void bfs(int a, int b){
    int wolf = 0;
    int sheep = 0;

    q.push({a, b});
    visited[a][b] = 1;

    while(!q.empty()){
        auto[y, x] = q.front(); q.pop();
        if(arr[y][x] == 'v') wolf++;
        else if(arr[y][x] == 'o') sheep++;

        for(int d = 0; d < 4; d++){
            int ny = y + dy[d];
            int nx = x + dx[d];

            if(isRange(ny, nx) && visited[ny][nx] == 0 && arr[ny][nx] != '#'){
                q.push({ny, nx});
                visited[ny][nx] = 1;
            }
        }
    }

    if(sheep <= wolf){
        S -= sheep;
    }else{
        W -= wolf;
    }

}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> M;
    for(int i =1; i<= N; i++ ){
        for(int j = 1; j <= M; j++){
            char a;
            cin >> a;
            if(a == 'v') W++;
            else if(a == 'o') S++;
            arr[i][j] = a;
        }
    }


    for(int i = 1; i<= N; i++){
        for(int j = 1; j<= M; j++){
            if(arr[i][j] != '#' && visited[i][j] == 0){
                bfs(i, j);
            }
        }
    }

    cout << S << " " << W;

}