#include <iostream>
#include <vector>
#include <set>
#include <map>
#include <unordered_set>
#include <unordered_map>
#include <queue>
#include <deque>
#include <stack>
#include <algorithm>
#include <string>

typedef long long ll;
const int INF = 1e9;

using namespace std;

map<ll, ll> m;

int N, Q;
ll sum = 0;
ll prefixSum = 0;
ll inflation = 0;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N;
    for(int i =0 ; i< N; i++){
        int a;
        cin >> a;
        m[a]++;
        sum += a;
    }

    cin >> Q;
    for(int i = 0; i < Q; i++){
        string s;
        ll x, y;
        cin >> s;
        if(s == "INFLATION"){
            cin >> x;
            inflation += x;
            sum += (N * x);
            // cout << " inflation = " << inflation << "\n";
        }else{
            cin >> x >> y;
            //존재하면
            if(m.find(x - inflation) != m.end()){
                int cnt = m[x - inflation];
                sum -= (x * cnt);
                sum += (y * cnt);
                // cout << "i = " << i << " x + inflation = " << x + inflation << " cnt = " << cnt << " sum  = " << sum << "\n";
                m.erase(x - inflation);
                m[y - inflation]+=cnt;
            }
        }

        cout << sum << "\n";
    }
}
// 16 - (2 * 3) = 10
// 10 + (2 * 2) = 14;

/**
 * 
 * 1
 * 값   1    2   5
 * 개수  2    2   1
 * 누적합   :   0
 * 합       :   11
 * ---
 * 2
 * 값   1    2   5
 * 개수  2    2   1
 * 누적합   :   5
 * 합       :   11
 * ---
 * 3
 * 값   1    2   5
 * 개수  2    2   1
 * 누적합   :   5   (1)
 * 합       :   11
 * ---
 */