#include <iostream>
#include <vector>

using namespace std;

int parent[1001];

int find(int x) {
    if (parent[x] == x) return x;
    return parent[x] = find(parent[x]);
}

void merge(int a, int b) {
    a = find(a);
    b = find(b);
    if (a != b) parent[a] = b;
}

int n, m;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n >> m;
    for (int i = 1; i <= n; i++) parent[i] = i;

    vector<vector<int>> enemy(n + 1);

    for (int i = 0; i < m; i++) {
        char c;
        int a, b;
        cin >> c >> a >> b;

        if (c == 'F') {
            merge(a, b);
        } else {
            enemy[a].push_back(b);
            enemy[b].push_back(a);
        }
    }

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j < enemy[i].size(); j++) {
            merge(enemy[i][0], enemy[i][j]);
        }
    }

    int res = 0;
    for (int i = 1; i <= n; i++) {
        if (find(i) == i) res++;
    }

    cout << res;
}