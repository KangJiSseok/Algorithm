#include <iostream>
#include <vector>
#include <algorithm>

using ll = long long;
using namespace std;
 
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
 
    int N;
    ll M;
    cin >> N >> M;
 
    vector<ll> p(N);
    for (int i = 0; i < N; i++) cin >> p[i];
 
    vector<ll> s;
    s.push_back(0);
    for (int i = 0; i < N; i++)
        if (p[i] <= M) s.push_back(p[i]);
    for (int i = 0; i < N; i++)
        for (int j = i; j < N; j++) {
            ll v = p[i] + p[j];
            if (v <= M) s.push_back(v);
        }
 
    sort(s.begin(), s.end());
    s.erase(unique(s.begin(), s.end()), s.end());
 
    ll ans = 0;
    for (ll a : s) {
        if (a > M) break;
        ll rem = M - a;
        auto it = upper_bound(s.begin(), s.end(), rem);
        ll b = *(--it);
        ans = max(ans, a + b);
    }
 
    cout << ans;
    return 0;
}