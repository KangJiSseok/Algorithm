#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N;
int arr[1000];  

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N;
    for(int i =0; i< N; i++){
        cin >> arr[i];
    }

    sort(arr, arr + N);

    int answer = 1;
    for(int i =0; i< N; i++){
        if(arr[i] > answer) break;
        answer += arr[i];
    }

    cout << answer;
}