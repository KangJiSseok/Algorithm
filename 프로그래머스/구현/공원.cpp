#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int N, M;
bool isRange(int y, int x){
    return 0 <= y && y < N && 0 <= x && x < M;
}

int getCount(int y, int x, const vector<vector<string>> &park){
    int ey = y;
    int ex = x;
    int cnt = 1;
    while(1){
        ex++;
        ey++;
        if(!isRange(ey, ex)) return cnt;
        for(int i = y; i <= ey; i++){
            if(park[i][ex] != "-1") return cnt;
        }
        for(int i = x; i <= ex; i++){
            if(park[ey][i] != "-1") return cnt;
        }
        cnt++;
    }

    return -1;
}

int solution(vector<int> mats, vector<vector<string>> park) {
    
    N = park.size();
    M = park[0].size();
    int map[N][M];
    fill(&map[0][0], &map[0][0] + N * M, 0);

    for(int i =0; i < N; i++){
        for(int j = 0; j < M; j++){
            if(park[i][j] == "-1"){
                map[i][j] = getCount(i, j, park);
            }
        }
    }

    int MAX = 0;
    for(int i =0; i < N; i++){
        // cout << "\n";
        for(int j= 0; j < M; j++){
            // cout << map[i][j] << " ";
            MAX = max(MAX, map[i][j]);
        }
    }

    // cout << MAX;

    sort(mats.begin(), mats.end(), greater<int>());

    for(auto it : mats){
        if(MAX >= it) return it;
    }


    return -1;
}