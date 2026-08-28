#include <iostream>
#include <queue>
#include <vector>

using namespace std;
typedef long long ll;

struct PQ{
    ll value;
};

struct compare{
    bool operator()(PQ a, PQ b){
        return a.value > b.value;
    }
};


priority_queue<PQ, vector<PQ>, compare> pq;
int N;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N;
    for(int i =0; i < N; i++){
        int a;
        cin >> a;
        pq.push({a});
    }

    ll sum = 0;
    while(pq.size() >= 2){
        PQ a = pq.top();
        pq.pop();
        PQ b = pq.top();
        pq.pop();

        ll c = a.value + b.value;
        sum += c;
        pq.push({c});
    }

    cout << sum;
}