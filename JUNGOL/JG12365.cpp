#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N;
int arr[300'002];

int ldp[300'002];
int rdp[300'002];

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N;
    for(int i = 1; i <= N; i++){
        int a;
        cin >> a;
        arr[i] = a;
    }


    for(int i = 1; i <= N; i++){
        ldp[i] = max(0, ldp[i - 1] + arr[i]);
    }

    for(int i = N; i >= 1; i--){
        rdp[i] = max(0, rdp[i + 1] + arr[i]);
    }

    for(int i = 1; i<= N; i++){
        cout << ldp[i - 1] + arr[i] + rdp[i + 1] << " ";
    }
    
}
