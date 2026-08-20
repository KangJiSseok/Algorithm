#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
typedef long long ll;
const int INF = 1e9;

int N;
vector<int> graph[100'001];
int MAX = 0;


int dfs(int node, int parent){
    int child1 = 0, child2 = 0;

    for(int child : graph[node]){
        if(child == parent) continue;
        int value = dfs(child, node);

        if(value > child1){
            child2 = child1;
            child1 = value;
        }else if(value > child2){
            child2 = value;
        }
    }

    MAX = max(MAX, 1 + child1 + child2);
    return 1 + child1;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N;
    for(int i =0 ; i< N - 1; i++){
        int a, b;
        cin >> a >> b;
        graph[a].push_back(b);
        graph[b].push_back(a);
    }

    dfs(1, 0);
    cout << MAX - 1;

}