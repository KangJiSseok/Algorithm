#include <iostream>
#include <vector>
using namespace std;

int solution(int n, vector<int> stations, int w)
{
    int answer = 0;

    int cur = 0;


    for(int station : stations){
        int coverage = station - cur - w - 1;

        if(coverage > 0){
            answer += (coverage + ((w * 2 + 1) - 1)) / (w * 2 + 1);
        }
        
        cur = station + w;
        
    }

    if(cur <= n){
        int coverage = n - cur;
        answer += (coverage + ((w * 2 + 1) - 1)) / (w * 2 + 1);
    }

    return answer;
}

/**
 * 
 * 1    2   3   4   5   6   7   8   9   10  11  12  13  14  15
 *                              x               x
 *                          o   o   o       o   o   o
 *          12 - 9 - 1 - 1
 */