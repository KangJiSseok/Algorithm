#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;

int map[102][102];
int dist[102][102];
int N;
int my, mx;

int dy[] = {-1, 0, 0, 1};
int dx[] = {0, -1, 1, 0};

struct Node{
    int y, x, cost;
};

struct Compare{
    bool operator()(Node a, Node b){
        return a.cost > b.cost;
    }
};

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N;
    cin >> my >> mx;

    for(int i = 1; i <= N; i++ ){
        for(int j = 1; j <= N; j++){
            cin >> map[i][j];
        }
    }

    fill(&dist[0][0], &dist[0][0] + 102 * 102, 1e9);

    priority_queue<Node, vector<Node>, Compare> pq;
    dist[my][mx] = 0;
    pq.push({my, mx, 0});

    int answer = -1;
    while(!pq.empty()){
        Node node = pq.top();
        pq.pop();
        if(node.cost > dist[node.y][node.x]) continue;
        if(node.y <= 0 || node.y > N || node.x <= 0 || node.x > N){
            answer = node.cost;
            break;
        }

        for(int d = 0; d < 4; d++){
            int ny = node.y + dy[d];
            int nx = node.x + dx[d];
            int up = map[node.y][node.x] - map[ny][nx];
            int cost;
            if(up > 0) cost = up * up;
            else if(up < 0) cost = -up;
            else cost = 0;
            int nd = dist[node.y][node.x] + cost;
            if(nd < dist[ny][nx]){
                dist[ny][nx] = nd;
                pq.push({ny, nx, nd});
            }
        }
    }

    cout << answer;
}