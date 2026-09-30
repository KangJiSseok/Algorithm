#include <algorithm>
#include <iostream>

using namespace std;

int dp[101][100001];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, K;
    cin >> N >> K;

    for (int i = 0; i <= N; i++)
        fill(dp[i], dp[i] + K + 1, -1);
    dp[0][0] = 0;

    for (int i = 1; i <= N; i++) {
        int a, b, c, d;
        cin >> a >> b >> c >> d;

        for (int t = 0; t <= K; t++) {
            if (dp[i - 1][t] == -1) continue;

            if (t + a <= K)
                dp[i][t + a] = max(dp[i][t + a], dp[i - 1][t] + b);

            if (t + c <= K)
                dp[i][t + c] = max(dp[i][t + c], dp[i - 1][t] + d);
        }
    }

    int answer = 0;
    for (int i = 0; i <= K; i++) {
        answer = max(answer, dp[N][i]);
    }
    cout << answer;

    return 0;
}
