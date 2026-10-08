#include <iostream>
#include <queue>
#include <vector>

typedef long long ll;
using namespace std;

int N, M;

struct Edge{
    int v;
    ll cost;

    bool operator()(Edge &a, Edge &b){
        return a.cost > b.cost;
    }
};

vector<Edge> graph[100'001];
ll dist[100'001];
priority_queue<Edge, vector<Edge>, Edge> pq;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> M;
    for(int i =0; i< M; i++){
        int u , v, c;
        cin >> u >> v >> c;
        graph[u].push_back({v, c});
    }

    fill(dist, dist + 100001, 1LL << 60);
    pq.push({1, 0});
    dist[1] = 0;
    while(!pq.empty()){
        auto[u, c] = pq.top(); pq.pop();
        if(dist[u] < c) continue;
        if(u == N) break;

        for(auto[v, cost] : graph[u]){
            if(dist[u] + cost < dist[v]){
                dist[v] = dist[u] + cost;
                pq.push({v, dist[v]});
            }
        }
    }

    cout << dist[N];
}