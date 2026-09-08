#include <iostream>
#include <algorithm>

using namespace std;
typedef long long ll;

ll N;
ll arr[50'001];
ll dp[50'001];
ll a[2][7];

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    fill(&a[0][0], &a[0][0] + 2 * 7 , -1);
    a[0][0] = 0;

    cin >> N;
    for(int i = 1; i <= N; i++){
        cin >> arr[i];
        dp[i] = (dp[i - 1] + arr[i]) % 7;
    }


    for(int i = 1; i <= N; i++){
        if(a[0][dp[i]] == -1){
            a[0][dp[i]] = i;
        }else{
            a[1][dp[i]] = i;
        }
    }

    ll MAX = 0;
    for(int i =0; i< 7; i++){
        if(a[0][i] != -1 && a[1][i] != -1){
            MAX = max(MAX, a[1][i] - a[0][i]);
        }
    }
    cout << MAX;
}