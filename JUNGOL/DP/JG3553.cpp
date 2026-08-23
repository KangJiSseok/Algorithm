#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
    int N, M;
    cin >> N >> M;

    vector<int> a(N);
    for(int i = 0; i < N; i++) cin >> a[i];

    vector<bool> dp0(M, false), dp1(M, false);
    dp0[0] = true;

    for(int i = 0; i < N; i++){
        vector<bool> ndp0(M, false), ndp1(M, false);
        for(int r = 0; r < M; r++){
            if(dp0[r] || dp1[r]) ndp0[r] = true;
            if(dp0[r]) ndp1[(r + a[i]) % M] = true;
        }
        dp0 = ndp0;
        dp1 = ndp1;
    }

    int ans = 0;
    for(int r = 0; r < M; r++)
        if(dp0[r] || dp1[r]) ans = max(ans, r);

    cout << ans;
    return 0;
}