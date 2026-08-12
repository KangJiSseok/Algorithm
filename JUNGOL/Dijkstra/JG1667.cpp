#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;
typedef long long ll;

const ll INF = 1e18;

struct Edge {
    int to;
    int weight;
    int idx;
};
struct Compare {
    bool operator()(const pair<ll,int>& a, const pair<ll,int>& b) {
        return a.first > b.first;
    }
};

int N, M;
vector<Edge> adj[1001];

ll dijkstra(int blockedEdge, vector<int>& parentEdge) {
    vector<ll> dist(N + 1, INF);
    parentEdge.assign(N + 1, -1);
    priority_queue<pair<ll,int>, vector<pair<ll,int>>, Compare> pq;

    dist[1] = 0;
    pq.push({0, 1});
    while (!pq.empty()) {
        auto [d, u] = pq.top(); pq.pop();
        if (d > dist[u]) continue;
        for (const Edge& e : adj[u]) {
            if (e.idx == blockedEdge) continue;
            if (dist[u] + e.weight < dist[e.to]) {
                dist[e.to] = dist[u] + e.weight;
                parentEdge[e.to] = e.idx;
                pq.push({dist[e.to], e.to});
            }
        }
    }
    return dist[N];
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N >> M;
    for (int i = 0; i < M; i++) {
        int a, b, t;
        cin >> a >> b >> t;
        adj[a].push_back({b, t, i});
        adj[b].push_back({a, t, i});
    }

    vector<int> parentEdge;
    ll base = dijkstra(-1, parentEdge);

    //역추정 경로
    vector<int> pathEdges;
    for (int v = N; v != 1; ) {
        int idx = parentEdge[v];
        pathEdges.push_back(idx);
        for (const Edge& e : adj[v]){
            if (e.idx == idx) { 
                v = e.to; 
                break;
            }
        }
    }

    ll answer = 0;
    vector<int> dummy;
    for (int idx : pathEdges) {
        ll d = dijkstra(idx, dummy);
        if (d == INF) { 
            answer = -1; 
            break; 
        }
        answer = max(answer, d - base);
    }

    cout << answer;
    return 0;
}