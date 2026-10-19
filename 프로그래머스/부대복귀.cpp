#include <string>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

vector<int> graph[100'001];
int visited[100'001];

vector<int> solution(int n, vector<vector<int>> roads, vector<int> sources, int destination) {
    vector<int> answer;

    for(auto &road : roads){
        int u = road[0];
        int v = road[1];
        graph[u].push_back(v);
        graph[v].push_back(u);
    }

    queue<int> q;
    fill(visited, visited + 100'001, -1);
    q.push({destination});
    visited[destination] = 0;

    while(!q.empty()){
        auto u = q.front(); q.pop();

        for(auto v : graph[u]){
            if(visited[v] == -1){
                visited[v] = visited[u] + 1;
                q.push(v);
            }
        }
    }

    for(auto &source : sources){
        answer.push_back(visited[source]);
    }

    return answer;
}