#include <string>
#include <vector>
#include <queue>

using namespace std;

struct Node{
    int num, time;
};

struct Compare{
    bool operator()(Node a, Node b){
        if(a.time == b.time) return a.num > b.num;
        return a.time > b.time;
    }
};

int solution(int n, vector<int> cores) {
    int ans = -1;

    priority_queue<Node, vector<Node>, Compare> pq;
    for(int i =0 ; i< cores.size(); i++){
        pq.push({i, cores[i]});
    }
    
    int len = n - cores.size();
    for(int i = 0; i < len; i++){
        auto[nu, t] = pq.top(); pq.pop();

        ans = nu + 1;

        pq.push({nu, t + cores[nu]});
    }

    return ans;
    
}