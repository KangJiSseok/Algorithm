#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>


using namespace std;


int N, M, X;
vector<vector<int>> graph;
vector<vector<int>> reverseGraph;


int BFS(vector<vector<int>> &g){
    int cnt = 0;

    vector<bool> visited(N + 1, false);

    queue<int> q;
    q.push({X});
    visited[X] = true;

    while(!q.empty()){
        int x = q.front(); q.pop();
        cnt++;

        for(int nx : g[x]){
            if(!visited[nx]){
                visited[nx] = true;
                q.push({nx});
            }
        }
    }

    return cnt;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    cin >> N >> M >> X;

    graph.resize(N + 1);
    reverseGraph.resize(N + 1);

    for(int i = 0; i < M; i++){
        int a, b;
        cin >> a >> b;
        graph[a].push_back(b);
        reverseGraph[b].push_back(a);
    }

    cout << BFS(reverseGraph) << " ";
    cout << N - BFS(graph) + 1 << "\n";
}