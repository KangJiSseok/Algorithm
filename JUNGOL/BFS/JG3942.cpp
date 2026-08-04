#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include<unordered_set>
#include<unordered_map>
#include<cstring>
#include <set>
#include <map>
#include <stack>

using namespace std;
using ll = long long;


int T, A, B;
bool visited[5'000'001][2];

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> T >> A >> B;    

    queue<pair<int, int>> q;
    q.push({0, 0});
    visited[0][0] = true;

    int MAX = -1;
    while(!q.empty()){
        auto[t, a] = q.front();
        q.pop();
        MAX = max(MAX, t);

        if(t + A <= T && !visited[t + A][a]){
            q.push({t + A, a});
            visited[t + A][a] = true;
        }

        if(t + B <= T && !visited[t + B][a]){
            q.push({t + B, a});
            visited[t + B][a] = true;
        }
        
        if(a == 0 && !visited[t / 2][1]){
            q.push({t / 2, 1});
            visited[t / 2][1] = true;
        }
    }

    cout << MAX;

}