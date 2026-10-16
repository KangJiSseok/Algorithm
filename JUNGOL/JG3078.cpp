#include <iostream>
#include <queue>
#include <set>

using namespace std;

int a, b, c, d;
int answer = -1;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> a >> b >> c >> d;

    set<pair<int, int>> visited;
    queue<tuple<int, int, int>> q;

    q.push({0, 0, 0});
    visited.insert({0, 0});

    while (!q.empty()) {
        auto [A, B, cnt] = q.front();
        q.pop();

        if (A == c && B == d) {
            answer = cnt;
            break;
        }

        // 1. F(A)
        if (visited.insert({a, B}).second) {
            q.push({a, B, cnt + 1});
        }

        // 2. F(B)
        if (visited.insert({A, b}).second) {
            q.push({A, b, cnt + 1});
        }

        // 3. E(A)
        if (visited.insert({0, B}).second) {
            q.push({0, B, cnt + 1});
        }

        // 4. E(B)
        if (visited.insert({A, 0}).second) {
            q.push({A, 0, cnt + 1});
        }

        // 5. M(A, B)
        int spaceB = b - B;
        if (A <= spaceB) {
            if (visited.insert({0, B + A}).second) {
                q.push({0, B + A, cnt + 1});
            }
        } else {
            if (visited.insert({A - spaceB, b}).second) {
                q.push({A - spaceB, b, cnt + 1});
            }
        }

        // 6. M(B, A)
        int spaceA = a - A;
        if (B <= spaceA) {
            if (visited.insert({A + B, 0}).second) {
                q.push({A + B, 0, cnt + 1});
            }
        } else {
            if (visited.insert({a, B - spaceA}).second) {
                q.push({a, B - spaceA, cnt + 1});
            }
        }
    }

    cout << answer;
}