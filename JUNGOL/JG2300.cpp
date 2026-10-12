#include <iostream>
#include <vector>
#include <algorithm>

typedef long long ll;
using namespace std;

int N;
vector<ll> arr;
ll result[2] = {0, 0};

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N;
    for(int i=0; i< N; i++){
        ll a;
        cin >> a;
        arr.push_back(a);
    }

    sort(arr.begin(), arr.end());

    int l = 0;
    int r = arr.size() - 1;
    ll ABS = 1LL << 60;
    while(l < r){
        ll mid = arr[l] + arr[r];

        if(abs(mid) < ABS){
            ABS = abs(mid);
            result[0] = arr[l];
            result[1] = arr[r];
        }

        if(mid > 0){
            r--;
        }else{
            l++;
        }
    }
    
    cout << result[0] << " " << result[1];
}