#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <deque>
#include <map>
#include <set>
#include <unordered_map>
#include <unordered_set>

using namespace std;
const int INF = 1e9;

struct Edge{
    int v, w;
};

struct Cmp{
    bool operator()(Edge a, Edge b){
        return a.w > b.w;
    }
};

vector<Edge> graph[1'001];

int N, M, X;

int dijkstra(int src, int dest){
    int dist[1'001];
    fill(&dist[0], &dist[0] + 1001, INF);

    priority_queue<Edge, vector<Edge>, Cmp> pq;
    pq.push({src, 0});
    dist[src] = 0;
    while(!pq.empty()){
        Edge e = pq.top();
        pq.pop();
        if(e.w > dist[e.v]) continue;
        if(e.v == dest) return e.w;

        for(Edge v : graph[e.v]){
            if(e.w + v.w <= dist[v.v]){
                dist[v.v] = e.w + v.w;
                pq.push({v.v, dist[v.v]});
            }
        }
    }

    return -1;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> M >> X;

    for(int i = 0; i < M; i++){
        int u, v, w;
        cin >> u >> v >> w;
        graph[u].push_back({v, w});
    }

    int MAX = -1;

    for(int i = 1; i<= N; i++){
        MAX = max(MAX, dijkstra(i, X) + dijkstra(X, i));
    }

    cout << MAX;
    
}