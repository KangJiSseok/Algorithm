#include <iostream>
#include <vector>
#include <algorithm>

typedef long long ll;
using namespace std;

int N, M;
vector<ll> arr;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> M;

    ll l = 0;
    ll r = 0;

    for (int i = 0; i < N; i++) {
        ll a;
        cin >> a;
        arr.push_back(a);
        l = max(l, a);
        r += a;
    }

    while (l < r) {
        ll mid = (l + r) / 2;
        ll sum = 0;
        ll cnt = 1;

        for (int i = 0; i < N; i++) {
            sum += arr[i];

            if (sum > mid) {
                sum = arr[i];
                cnt++;
            }
        }

        if (cnt > M) {
            l = mid + 1;
        } else {
            r = mid;
        }
    }

    cout << l;
}