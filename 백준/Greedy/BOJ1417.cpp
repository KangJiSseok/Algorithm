#include <iostream>
#include <cmath>
#include <queue>

using namespace std;
int arr[51];
int N;


int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N;

    priority_queue<int> pq;

    int F;
    cin >> F;
    for(int i =2; i<= N; i++){
        int a;
        cin >> a;
        pq.push(a);
    }

    int cnt = 0;
    while (!pq.empty() && pq.top() >= F) {
        int a = pq.top();
        pq.pop();

        pq.push(a - 1);
        cnt++;
        F++;
    }

    cout << cnt;

}