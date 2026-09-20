#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;


struct Edge{
    int v, cost;
};

struct Compare{
    bool operator()(Edge a, Edge b){
        return a.cost > b.cost;
    }
};

vector<Edge> graph[200];
int dist[200];
int E;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> E;

    for(int i =0;  i< E; i++){
        char a, b;
        int c;
        cin >> a >> b >> c;
        graph[a].push_back({b, c});
        graph[b].push_back({a, c});
    }

    priority_queue<Edge, vector<Edge>, Compare> pq;
    fill(dist, dist + 200, 1e9);
    pq.push({'Z', 0});
    dist['Z'] = 0;

    int ans = -1;
    while(!pq.empty()){
        Edge e = pq.top();
        // cout << (char) e.v << " ";
        pq.pop();
        int ev = e.v;
        int ecost = e.cost;

        if(dist[ev] < ecost) continue;
        if('A' <= ev && ev <= 'Z' - 1) {
            cout << (char) ev << " " << ecost;
            break;
        }

        for(auto [v, cost] : graph[ev]){
            int ncost = ecost + cost;
            if(dist[v] > ncost){
                dist[v] = ncost;
                pq.push({v, ncost});
            }
        }
    }
}