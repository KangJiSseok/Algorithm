#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;

    vector<vector<int>> g(n + 1);
    for (int e = 0; e < n - 1; e++) {
        int i, j, w;
        cin >> i >> j >> w;
        g[i].push_back(j);
        g[j].push_back(i);
    }

    vector<int> cnt(n + 1, 0);
    for (int t = 0; t < k; t++) {
        int a;
        cin >> a;
        cnt[a] = 1;
    }

    vector<int> par(n + 1, 0);
    vector<int> ord;
    vector<int> vis(n + 1, 0);
    queue<int> q;

    q.push(1);
    vis[1] = 1;

    //순서대로 자식-부모관계 만들기
    while (!q.empty()) {
        int u = q.front();
        q.pop();
        ord.push_back(u);
        for (int v : g[u]) {
            if (!vis[v]) {
                vis[v] = 1;
                par[v] = u;
                q.push(v);
            }
        }
    }


    for (int idx = ord.size() - 1; idx >= 0; idx--) {
        int u = ord[idx];
        if (par[u] != 0) cnt[par[u]] += cnt[u];
    }

    int ans = 0;
    for (int p = 1; p <= n; p++) {
        bool bad = false;

        //자식 방향일때
        for (int v : g[p]) {
            if (v == par[p]) continue;
            if (cnt[v] == k) bad = true;
        }

        //부모 방향일때
        if (cnt[p] == 0) bad = true;

        if (!bad) ans++;
    }

    cout << ans;
    return 0;
}