#include <iostream>
#include <queue>
#include <vector>

typedef long long ll;

struct Node{
    //고객 번호
    ll num;
    // 구매한 개수
    ll w;
    //시간
    ll time;
    //k
    ll k;
};

//쇼핑몰 INPUT 
struct MinCompare{
    bool operator()(Node a, Node b){
        if(a.time == b.time){
            return a.k < b.k;
        }
        return a.time > b.time;
    }
};

//쇼핑몰 남은 자리 K개
struct KCompare{
    bool operator()(Node a, Node b){
        return a.k > b.k;
    }
};

using namespace std;

ll N, K;

priority_queue<Node, vector<Node>, MinCompare> minPQ;
priority_queue<Node, vector<Node>, KCompare> KPQ;

vector<pair<ll, ll>> arr;
vector<ll> result;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> K;

    for(ll i = 0; i < N; i++){
        ll a, b;
        cin >> a >> b;
        arr.push_back({a, b});
    }


    for(ll i = 1; i <= K; i++){
        KPQ.push({0, 0, 0, i});
    }

    ll idx = 0;
    ll time = 0;
    while(idx < N){
        // 1. 먼저 반납
        while(!minPQ.empty() && minPQ.top().time <= time){
            Node p = minPQ.top();
            minPQ.pop();
            KPQ.push({0, 0, 0, p.k});
            result.push_back(p.num);
        }

        // 2. 그 다음 배정
        while(idx < N && !KPQ.empty()){
            Node p = KPQ.top();
            KPQ.pop();
            ll id = arr[idx].first;
            ll w = arr[idx].second;
            minPQ.push({id, w, time + w, p.k});
            idx++;
        }

        time++;
    }

    //3. 계산 끝난애 내보내기
    while(!minPQ.empty()){
        while(!minPQ.empty() && minPQ.top().time <= time){
            Node p = minPQ.top();
            minPQ.pop();
            KPQ.push({0, 0, 0, p.k});
            result.push_back(p.num);
        }
        time++;
    }


    ll cul = 0;
    for(ll i = 1; i <= (ll)result.size(); i++){
        cul += result[i - 1] * i;
    }

    cout << cul;
}