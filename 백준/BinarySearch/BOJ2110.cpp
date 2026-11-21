#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, C;
vector<int> arr;

int upper_bound(){

    int l = 0;
    int r = 1'000'000'000;

    while(l < r){
        int mid = (l + r) / 2;

        int pos = arr[0];
        int cnt = 1;

        for(int i = 1; i < N; i++){
            int dis = arr[i] - pos;
            if(dis > mid){
                pos = arr[i];
                cnt++;
            }
        }

        if(C <= cnt){
            l = mid + 1;
        }else{
            r = mid;
        }
    }

    return l;

}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> C;
    for(int i = 0 ; i< N; i++){
        int a;
        cin >> a;
        arr.push_back(a);
    }

    sort(arr.begin(), arr.end());

    cout << upper_bound();
}