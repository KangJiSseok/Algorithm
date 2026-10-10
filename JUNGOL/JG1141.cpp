#include <iostream>
#include <stack>

using namespace std;

long long N, answer = 0;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N;

    stack<long long> s;

    for(int i =0; i< N; i++){
        int a;
        cin >> a;
        while(!s.empty() && s.top() <= a){
            s.pop();
        }

        answer += s.size();
        s.push(a);
    }

    cout << answer;

}