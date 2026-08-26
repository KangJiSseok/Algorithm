#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, K, S;
vector<pair<int, int>> l;
vector<pair<int, int>> r;

int main(){
    ios::sync_with_stdio(false);
    cin >> N >> K >> S;

    for(int i = 0; i < N; i++){
        int a, b;
        cin >> a >> b;
        if(a < S){
            l.push_back({abs(a - S), b});
        }else{
            r.push_back({abs(a - S), b});
        }
    }

    sort(l.begin(), l.end(), [](const pair<int, int> a, const pair<int, int> b){
        return a.first < b.first;
    });

    sort(r.begin(), r.end(), [](const pair<int, int> a, const pair<int, int> b){
        return a.first < b.first;
    });

    long long sum = 0;

    int idx = l.size() - 1;
    int k = 0;
    int curDist = -1;

    while(idx >= 0){
        if(k == 0) curDist = l[idx].first;

        int take = min(l[idx].second, K - k);
        l[idx].second -= take;
        k += take;

        if(l[idx].second == 0) idx--;

        if(k == K || idx < 0){
            sum += 2LL * curDist;
            k = 0;
        }
    }

    idx = (int)r.size() - 1;
    k = 0;
    curDist = -1;

    while(idx >= 0){
        if(k == 0) curDist = r[idx].first;

        int take = min(r[idx].second, K - k);
        r[idx].second -= take;
        k += take;

        if(r[idx].second == 0) idx--;

        if(k == K || idx < 0){
            sum += 2LL * curDist;
            k = 0;
        }
    }

    cout << sum;
}