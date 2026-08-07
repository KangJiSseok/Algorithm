#include <iostream>
#include <deque>

using namespace std;
using ll = long long;

ll N;
ll arr[500'001];
ll result[500'001];
deque<pair<int, int>> deq;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> N;
    for(ll i = 1; i <= N; i++){
        cin >> arr[i];
    }

    for(ll i = N; i >= 1; i--){
        while(!deq.empty() && deq.back().second >= arr[i]){
            auto [a, b] = deq.back();
            deq.pop_back();
            result[a] = i;
        }
        deq.push_back({i, arr[i]});
    }

    while(!deq.empty()){
        auto [a, b] = deq.back();
        deq.pop_back();
        result[a] = 0;
    }

    for(int i = 1; i <= N; i++){
        cout << result[i] << " ";
    }

    return 0;
}


/**
 * 
 * 10
 * 3
 *      7       (3)
 *      4       (7)
 *      12      (4)
 * 2
 */