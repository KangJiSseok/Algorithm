#include <iostream>
#include <vector>
#define INF 1e9
#define MINF -1e9

using namespace std;

int N, K;
vector<int> arr;


class MinSegment{
public:    
    vector<int> minTree;

    MinSegment(int n){
        minTree.resize(4*n, INF);
    }

    void build(int node, int start, int end){
        if(start == end){
            minTree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;

        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);
        minTree[node] = min(minTree[2 * node], minTree[2 * node + 1]);
    }

    int query(int node, int start, int end, int l, int r){
        if(r < start || end < l) return INF;
        if(l <= start && end <= r) return minTree[node];

        int mid = (start + end) / 2;

        return min(
            query(node * 2, start, mid, l, r),
            query(node * 2 + 1, mid + 1, end, l, r)
        );
    }
};

class MaxSegment{
public:    
    vector<int> maxTree;

    MaxSegment(int n){
        maxTree.resize(4*N, MINF);
    }


    void build(int node, int start, int end){
        if(start == end){
            maxTree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;

        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);
        maxTree[node] = max(maxTree[2 * node], maxTree[2 * node + 1]);
    }

    int query(int node, int start, int end, int l, int r){
        if(r < start || end < l) return MINF;
        if(l <= start && end <= r) return maxTree[node];

        int mid = (start + end) / 2;

        return max(
            query(node * 2, start, mid, l, r),
            query(node * 2 + 1, mid + 1, end, l, r)
        );
    }
};


int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    cin >> N >> K;
    arr.resize(N + 1);
    for(int i=1; i<= N; i++){
        cin >> arr[i];
    }

    MinSegment minTree = MinSegment(N);
    MaxSegment maxTree = MaxSegment(N);

    minTree.build(1, 1, N);
    maxTree.build(1, 1, N);

    for(int i = 1; i<= N - K + 1; i++){
        cout << minTree.query(1, 1, N, i, i + K - 1) << " ";
    }
    cout << "\n";
    for(int i = 1; i<= N - K + 1; i++){
        cout << maxTree.query(1, 1, N, i, i + K - 1) << " ";
    }

}