#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N;
priority_queue<int, vector<int>, greater<int>> pq;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N;
    for(int i=0; i< N; i++){
        int a;
        cin >> a;
        pq.push(a);
    }

    int sum = 0;
    while(pq.size() != 1){
        int a = pq.top(); pq.pop();
        int b = pq.top(); pq.pop();

        pq.push({a + b});
        sum += (a + b);
    }

    cout << sum;
}