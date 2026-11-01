#include <string>
#include <vector>
#include <algorithm>
#include <queue>
#include <iostream>

using namespace std;

int N, M;
char map[52][52];
// 1 : 갈 수 없음. -1 : 갈 수 있음
int visited[52][52];
bool visited2[52][52];
int dy[4] = {-1, 0, 0, 1};
int dx[4] = {0, -1, 1, 0};

queue<pair<int, int>> q;
void setQueue(){
    q = queue<pair<int, int>>();
    fill(&visited2[0][0], &visited2[0][0] + 52 * 52, false);

    for(int i = 0; i <= M + 1; i++){
        q.push({0, i});
        q.push({N + 1, i});
        visited2[0][i] = true;
        visited2[N + 1][i] = true;
    }

    for(int i = 1; i <= N; i++){
        q.push({i, 0});
        q.push({i, M + 1});
        visited2[i][0] = true;
        visited2[i][M + 1] = true;
    }
}

bool isRange(int y, int x){
    return 1 <= y && y <= N && 1 <= x && x <= M;
}

void twoAlpha(char c){

    for(int i =1 ;i <= N; i++){
        for(int j = 1; j <= M; j++){
            if(map[i][j] == c){
                visited[i][j] = -1;
            }
        }        
    }

}

void oneAlpha(char c){
    setQueue();
    
    queue<pair<int, int>> q2;

    while(!q.empty()){
        auto[y, x] = q.front(); q.pop();
        
        for(int d = 0; d < 4; d++){
            int ny = y + dy[d];
            int nx = x + dx[d];

            if(!isRange(ny, nx) || visited2[ny][nx]) continue;

            if(visited[ny][nx] == -1){
                q.push({ny, nx});
            }

            if(visited[ny][nx] == 1 && map[ny][nx] == c){
                q2.push({ny, nx});
            }

            visited2[ny][nx] = true;
        }
    }


    while(!q2.empty()){
        auto[y, x] = q2.front(); q2.pop();
        visited[y][x] = -1;
    }

}

int solution(vector<string> storage, vector<string> requests) {
    int answer = 0;
    
    N = storage.size();
    M = storage[0].size();
    fill(&visited[0][0], &visited[0][0] + 52 * 52, -1);

    for(int i = 1; i <= N; i++){
        for(int j = 1; j <= M; j++){
            map[i][j] = storage[i - 1][j - 1];
            visited[i][j] = 1;
        }
    }
    
    int cnt = 1;
    for(string &str: requests){
        cout <<"\n";
        cout << " cnt = " << cnt++ << " \n";
        if(str.size() == 1){
            oneAlpha(str[0]);
        }else{
            twoAlpha(str[0]);
        }

        for(int i = 1; i<= N; i++){
            cout << "\n";
            for(int j = 1; j <= M; j++){
                cout << visited[i][j] << "    ";
            }
        }

    }


    
    return answer;
}