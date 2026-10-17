#include <string>
#include <vector>
#include <queue>

using namespace std;

int K, N;
vector<int> arr;
int answer = 1 << 30;

void simulation(vector<vector<int>>& reqs) {
    vector<priority_queue<int, vector<int>, greater<int>>> time(K);

    for (int i = 0; i < K; i++) {
        for (int j = 0; j < arr[i]; j++) {
            time[i].push(0);
        }
    }

    int total = 0;

    for (auto& req : reqs) {
        int a = req[0];
        int b = req[1];
        int c = req[2] - 1;

        int m = time[c].top(); time[c].pop();

        int start = max(a, m);
        total += start - a;

        time[c].push(start + b);
    }

    answer = min(answer, total);
}

//(n - k + k - 1) C (k - 1)
void com(int depth, int remain, vector<vector<int>> &reqs){
    if(depth == K - 1){
        arr[depth] = remain + 1;
        simulation(reqs);
        return;
    }
    
    for(int i =0; i <= remain; i++){
        arr[depth] = i + 1;
        com(depth + 1, remain - i, reqs);
    }
}


int solution(int k, int n, vector<vector<int>> reqs) {
    K = k, N = n;
    arr.resize(k);
    com(0, n - k, reqs);
    
    return answer;
}