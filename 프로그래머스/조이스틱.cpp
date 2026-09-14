#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;
vector<int> dif;

int solution(string name) {

    for(int i = 0; i< name.size(); i++){
        dif.push_back(min(abs(name[i] - 'A'), abs('A' + 26 -  name[i])));
    }

    int cnt = 0;
    for(int i = 0; i < dif.size(); i++){
        cnt += dif[i];
    }

    int n = dif.size();
    int mv = n - 1;

    for(int i = 0; i < n; i++){
        int nx = i + 1;
        while(nx < n && dif[nx] == 0) nx++;
        int c1 = i * 2 + (n - nx);
        int c2 = i + (n - nx) * 2;
        mv = min(mv, min(c1, c2));
    }

    return cnt + mv;
}