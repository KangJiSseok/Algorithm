#include <string>
#include <vector>
#include <map>
#include <iostream>

using namespace std;

int cnt = 0;
map<int, int> m;

vector<int> solution(int k, vector<int> score) {
    
    vector<int> a; 

    for(int s : score){
        if(cnt < k){
            m[s] += 1;
            cnt++;
            a.push_back(m.begin() -> first);
        }else{
            auto it = m.begin();
            if(it -> first > s) {
                a.push_back(m.begin() -> first);
                continue;
            }
            if(it -> second == 1){
                m.erase(it);
            }else{
                it -> second = it -> second - 1;
            }
            m[s] += 1;
            a.push_back(m.begin() -> first);
        }
    }

    return a;
}

