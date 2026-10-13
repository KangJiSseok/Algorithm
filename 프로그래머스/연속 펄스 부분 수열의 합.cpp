#include <string>
#include <vector>
#include <algorithm>

using namespace std;

typedef long long ll;

vector<ll> pulse1;
vector<ll> pulse2;

int n;

ll fun(vector<ll> &pulse){
    ll curSum = pulse[0];
    ll maxSum = pulse[0];
    
    for(int i = 1; i< n; i++){
        curSum = max(pulse[i], curSum + pulse[i]);
        maxSum = max(maxSum, curSum);
    }
    
    return maxSum;
}

ll solution(vector<int> sequence) {
    
    ll answer = 0;
    
    n = sequence.size();
    pulse1.resize(n);
    pulse2.resize(n);
    
    for(int i =0; i < n; i++){
        if(i % 2 == 0){
            pulse1[i] = sequence[i];
            pulse2[i] = sequence[i] * (-1);
        }else{
            pulse1[i] = sequence[i] * (-1);
            pulse2[i] = sequence[i];
        }
    }
    
    
    answer = max(fun(pulse1), fun(pulse2));
    
    return answer;
}