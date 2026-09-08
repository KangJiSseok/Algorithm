#include <iostream>
#include <algorithm>
using namespace std;

int ys[100'001], xs[100'001];

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M;
    cin >> N >> M;
    for(int i = 0; i < M; i++){
        cin >> ys[i] >> xs[i];
    }

    sort(ys, ys + M);
    sort(xs, xs + M);

    int Y = ys[(M - 1) / 2];
    int X = xs[(M - 1) / 2];

    long long sum = 0;
    for(int i = 0; i < M; i++){
        sum += abs(ys[i] - Y) + abs(xs[i] - X);
    }

    cout << sum;
}