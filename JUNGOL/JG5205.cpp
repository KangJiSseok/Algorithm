#include <iostream>
#include <vector>


using namespace std;

int N, M;
vector<pair<int, int>> graph[101];
int degree[101];

//dp[a][b] = a를 만드는데 필요한 b가 몇개 필요한지.
int dp[101][101];

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    

    cin >> N >> M;

    for(int i = 0; i < M; i++){
        int a, b, c;
        cin >> a >> b >> c;
        graph[b].push_back({a, c});
        degree[a]++;
    }


    vector<int> s;
    vector<int> a;
    for(int i =1; i <= N; i++){
        if(degree[i] == 0) {
            s.push_back(i);
            a.push_back(i);
            dp[i][i] = 1;
        }
    }

    while(!s.empty()){
        int cur = s.back(); s.pop_back();
        
        for(auto [next, cnt] : graph[cur]){
            for(int b : a){
                dp[next][b] += dp[cur][b] * cnt;
            }

            degree[next]--;

            if(degree[next] == 0){
                s.push_back(next);
            }
        }
    }


    for(int b : a){
        cout << b << " " << dp[N][b] << "\n";
    }


}