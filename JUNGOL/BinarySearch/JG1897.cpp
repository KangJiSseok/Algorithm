#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


vector<int> arr;
int N, C;


int upperBound(){
    int l = 0; 
    int r = 1'000'000'001;

    while(l < r){
        int mid = (l + r) / 2;

        int beforeIdx = 0;
        int cnt = 1;

        for(int i=1; i< N; i++){
            int dis = arr[i] - arr[beforeIdx];
            if(dis >= mid){
                cnt++;
                beforeIdx = i;
            }
        }

        //cnt 가 C보다 너무 작다 -> r 이 너무 크다.
        if(cnt < C){
            r = mid;
        }else{
            l = mid + 1;
        }
    }

    return l;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> N >> C;

    for(int i=0; i< N; i++){
        int a;
        cin >> a;
        arr.push_back(a);
    }

    sort(arr.begin(), arr.end());
    
    int result = upperBound();
    cout << result - 1;
}


/**
 * 
 * 
 * 
 * 1    2   3   4   5   6   7   8   9
 * o    o       o               o   o
 * 
 */


