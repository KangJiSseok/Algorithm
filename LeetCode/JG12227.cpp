#include <iostream>
#include <string>
#include <algorithm>

using namespace std;
typedef long long ll;

int A[300'002];
ll L[300'002], R[300'002];

int main(){
    ios::sync_with_stdio(false); 
    cin.tie(NULL); cout.tie(NULL);
    int N; ll K;
    cin >> N >> K;

    for(int i=1;i<=N;i++) cin >> A[i];

    for(int i=1;i<=N;i++) L[i] = A[i] + max(0LL, L[i-1]);
    for(int i=N;i>=1;i--) R[i] = A[i] + max(0LL, R[i+1]);
    string out; 
    out.reserve(N*4);

    for(int i=1;i<=N;i++)
        out += (L[i] + R[i] - A[i] >= K) ? "YES\n" : "NO\n";
    cout << out;
    
    return 0;
}