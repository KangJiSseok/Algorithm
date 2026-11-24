#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;
typedef long long ll;

vector<ll> arr;
ll N;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N;
    for(int i =0; i < N; i++){
        ll a;
        cin >> a;
        arr.push_back(a);
    }

    sort(arr.begin(), arr.end());

    int l = 0;
    int r = N - 1;
    ll MIN = (1L << 60);
    int result[2];
    while(l < r){
        ll sum = arr[l] + arr[r];
        ll ABS = abs(sum);
        if(ABS < MIN){
            result[0] = arr[l];
            result[1] = arr[r];
            MIN = ABS;
        }
        if(sum < 0){
            l++;
        }else if(sum == 0){
            break;
        }else{
            r--;
        }
    }

    cout << result[0] << " " << result[1];
}