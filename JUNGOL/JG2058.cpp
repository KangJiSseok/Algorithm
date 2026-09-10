#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int ddy[9] = {-1, -1, -1, 0, 1, 1, 1, 0, 0};
int ddx[9] = {-1, 0, 1, 1, 1, 0, -1, -1, 0};
int map[26][26];
int visited[26][26][26][26];
int N;

int ay, ax, by, bx;
int cy, cx, dy, dx;

struct Node{
    int ey, ex;
    int fy, fx;
};

bool isRange(int a, int b, int c, int d){
    return 1 <= a && a <= N && 
            1 <= b && b <= N && 
            1 <= c && c <= N && 
            1 <= d && d <= N;
}
bool isValid(int a, int b, int c, int d){
    return map[a][b] == 0 && map[c][d] == 0;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    fill(&visited[0][0][0][0], &visited[0][0][0][0] + 26 * 26 * 26 * 26, -1);

    cin >> N;
    cin >> ay >> ax >> by >> bx;
    cin >> cy >> cx >> dy >> dx;

    for(int i = 1; i<= N; i++){
        for(int j = 1; j <= N; j++){
            int a;
            cin >> a;
            map[i][j] = a;
        }
    }

    queue<Node> q;
    q.push({ay, ax, cy, cx});
    visited[ay][ax][cy][cx] = 0;

    while(!q.empty()){
        Node n = q.front();
        q.pop();

        if(n.ey == by && n.ex == bx && n.fy == dy && n.fx == dx){
            break;
        }

        for(int d =0; d < 9; d++){
            int ney = n.ey + ddy[d];
            int nex = n.ex + ddx[d];
            for(int dd =0; dd < 9; dd++){
                int nfy = n.fy + ddy[dd];
                int nfx = n.fx + ddx[dd];
                if(isRange(ney, nex, nfy, nfx) && isValid(ney, nex, nfy, nfx) 
                && max(abs(ney - nfy), abs(nex - nfx)) >= 2
                && visited[ney][nex][nfy][nfx] == -1 ){
                    visited[ney][nex][nfy][nfx] = visited[n.ey][n.ex][n.fy][n.fx] + 1;
                    q.push({ney, nex, nfy, nfx});
                }
            }
            
        }
    }

    cout << visited[by][bx][dy][dx];

}