#include <iostream>
#include <vector>
#include <algorithm>

const long long INF = -(1LL << 60);
using namespace std;

int N, M, K, S, T;
vector<pair<int, int>> edge[100001];
vector<int> graph[100001];
long long dp[100001][11];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> M >> K >> S >> T;

    for (int i = 0; i < M; i++) {
        int a, b, t;
        cin >> a >> b >> t;

        edge[a].push_back({b, t});
        graph[b].push_back(a);
    }

    
    fill(&dp[0][0], &dp[0][0] + 100001 * 11, INF);

    dp[S][0] = 0;

    for (int k = 0; k <= K; k++) {
        for (int i = 1; i <= N; i++) {
            if (dp[i][k] == INF) continue;

            for (auto [next, time] : edge[i]) {
                dp[next][k] = max(dp[next][k], dp[i][k] + time);
            }

            if (k < K) {
                for (int next : graph[i]) {
                    dp[next][k + 1] = max(dp[next][k + 1], dp[i][k]);
                }
            }
        }
    }

    long long answer = INF;

    for (int k = 0; k <= K; k++) {
        answer = max(answer, dp[T][k]);
    }

    cout << (answer == INF ? -1 : answer);
}