#include <iostream>
#include <vector>
#include <climits>

using namespace std;

int N;
pair<long long, vector<int>> graph[1000001];

long long answer = LLONG_MIN;
int cnt = 0;

int buildGraph() {
    int cur = cnt++;
    long long v, c;
    cin >> v >> c;

    graph[cur].first = v;

    for (int i = 0; i < c; i++) {
        int child = buildGraph();
        graph[cur].second.push_back(child);
    }

    return cur;
}

long long dfs(int node) {
    long long child1 = 0, child2 = 0;

    for (int child : graph[node].second) {
        long long sum = dfs(child);
        long long value = max(0LL, sum);

        if (value > child1) {
            child2 = child1;
            child1 = value;
        } else if (value > child2) {
            child2 = value;
        }
    }

    answer = max(answer, graph[node].first + child1 + child2);

    return graph[node].first + child1;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> N;

    int root = buildGraph();

    dfs(root);

    cout << answer;

    return 0;
}