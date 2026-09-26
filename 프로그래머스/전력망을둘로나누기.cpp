#include <string>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

vector<int> graph[101];
int visited[101];

int solution(int n, vector<vector<int>> wires) {
    int MIN = 1e9;

    for(int i =0; i < wires.size(); i++){
        int u = wires[i][0];
        int v = wires[i][1];
        graph[u].push_back(v);
        graph[v].push_back(u);
    }

    for(vector<int> wire : wires){
        int v1 = wire[0];
        int v2 = wire[1];
        fill(visited, visited + 101, -1);
        queue<int> q1, q2;
        q1.push(v1);
        visited[v1] = 1;
        int cnt1 = 0, cnt2 = 0;
        while(!q1.empty()){
            int u = q1.front(); q1.pop();
            cnt1++;

            for(int v : graph[u]){
                if(visited[v] == -1 && v != v2){
                    visited[v] = 1;
                    q1.push(v);
                }
            }
        }

        q2.push(v2);
        visited[v2] = 1;
        while(!q2.empty()){
            int u = q2.front(); q2.pop();
            cnt2++;
            for(int v : graph[u]){
                if(visited[v] == -1 && v != v1){
                    visited[v] = 1;
                    q2.push(v);
                }
            }
        }
        
        MIN = min(MIN, abs(cnt2 - cnt1));
    }

    return MIN;
}