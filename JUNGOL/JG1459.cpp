#include <iostream>
#include <vector>


using namespace std;

int N;
vector<int> graph;
int visited[101];   //0 : 방문x , 1 : 방문중, 2 : 방문완료
vector<int> answer;

void dfs(int cur){
    visited[cur] = 1;
    int next = graph[cur];

    if(visited[next] == 0){
        dfs(next);
    }else if(visited[next] == 1){
        int node = next;

        answer.push_back(node);
        node = graph[node];
        while(node != next){
            answer.push_back(node);
            node = graph[node];
        }
    }

    visited[cur] = 2;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N;

    graph.resize(N + 1);

    for(int i =1; i <= N; i++){
        int a;
        cin >> a;
        graph[i] = a;
    }


    for(int i = 1; i<= N; i++){
        if(visited[i] == 0) dfs(i);
    }

    sort(answer.begin(), answer.end());

    cout << answer.size() << "\n";
    for(int i : answer){
        cout << i << "\n";
    }
}