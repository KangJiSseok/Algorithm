#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> graph[100'001];
bool visited[100'001];
int result[100'001];

int N, M;
int idx = 1;

void dfs(int node){
    visited[node] = true;
    result[idx++] = node;

    for(int next : graph[node]){
        if(!visited[next]){
            dfs(next);
        }
    }
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> M;

    for(int i = 0; i < M; i++){
        int a, b;
        cin >> a >> b;
        graph[a].push_back(b);
        graph[b].push_back(a);
    }

    for(int i = 1; i <= N; i++){
        sort(graph[i].begin(), graph[i].end());
    }

    dfs(1);

    for(int i = 1; i <= N; i++){
        cout << result[i] << " ";
    }
}