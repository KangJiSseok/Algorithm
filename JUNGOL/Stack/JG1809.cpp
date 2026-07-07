#include <iostream>
#include <stack>
#include <vector>

using namespace std;

stack<pair<int, int>> s;
vector<int> arr, result;

int N;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> N;
    for(int i=0; i< N; i++){
        int a;
        cin >> a;
        arr.push_back(a);
    }

    result.assign(N, -1);

    for(int i=N - 1; i>= 0; i--){

        while(!s.empty() && s.top().second < arr[i]){
            auto it = s.top();
            s.pop();
            result[it.first] = i;
        }

        s.push({i, arr[i]});
    }

    while(!s.empty()){
        auto it = s.top();
        s.pop();
        result[it.first] = -1;
    }

    for(int i=0; i< N; i++){
        cout << result[i] + 1 << " ";
    }
}


/**
 * 
 * 4
 * 2
 */

/**
 * 
 *      -
 *      -
 *      -       -
 * -    -       -
 * -    -   -   -    
 * -    -   -   -   -
 * -    -   -   -   -
 * -    -   -   -   -
 * -    -   -   -   -  
 * 1    2   3   4   5
 * 0    0   2   2   4
 */