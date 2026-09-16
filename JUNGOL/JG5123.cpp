#include <iostream>
#include <string>
#include <queue>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    string s;
    cin >> s;

    priority_queue<int> a;
    priority_queue<int> b;
    priority_queue<int> ab;
    int ans = 0;

    for (int i = 0; i < s.size(); i++) {
        char c = s[i];

        if (c == 'A') {
            a.push(i);
        }
        else if (c == 'B') {
            if (!a.empty()) {
                int p = a.top();
                a.pop();
                ab.push(p);
                ans++;
            }
            else {
                b.push(i);
            }
        }
        else {
            if (!b.empty()) {
                b.pop();
                ans++;
            }
            else if (!ab.empty()) {
                int p = ab.top();
                ab.pop();
                a.push(p);
            }
        }
    }

    cout << ans;
}