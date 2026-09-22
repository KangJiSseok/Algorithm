#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

int F, N, M, B;

vector<tuple<int, int, int>> edge;
int dist[501];

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    cin >> F;

    for(int f = 0; f < F; f++){

        for(int i = 0; i < 501; i++){
            edge.clear();
            dist[i] = 1e9;
        }

        dist[1] = 0;
        cin >> N >> M >> B;
        //graph
        for(int i = 0; i < M; i++){
            int a, b, c;
            cin >> a >> b >> c;
            edge.push_back({a, b, c});
            edge.push_back({b, a, c});
        }

        for(int i = 0; i < B; i++){
            int a, b, c;
            cin >> a >> b >> c;
            edge.push_back({a, b, -c});
        }

        for(int i = 1; i <= N; i++){
            for(int j = 0; j < edge.size(); j++){
                auto[from, to, cost] = edge[j];
                if(dist[from] == 1e9) continue;
                if(dist[from] + cost < dist[to]) dist[to] = dist[from] + cost;
            }
        }

        bool is = false;
        for(int j = 0; j < edge.size(); j++){
            auto[from, to, cost] = edge[j];
            if(dist[from] == 1e9) continue;
            if(dist[from] + cost < dist[to]) {
                is = true;
                break;
            }
        }

        cout << (is ? "YES" : "NO") <<"\n";
        
    }
}