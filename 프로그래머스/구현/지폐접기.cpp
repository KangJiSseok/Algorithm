#include <string>
#include <vector>
#include <algorithm>

using namespace std;


bool isValid(vector<int> &wallet, vector<int> &bill){
    return ((wallet[0] >= bill[0]) && (wallet[1] >= bill[1])) || 
        ((wallet[0] >= bill[1]) && (wallet[1] >= bill[0]));
}

int solution(vector<int> wallet, vector<int> bill) {
    int answer = 0;

    while(1){
        if(isValid(wallet, bill)) break;
        
        if(bill[0] < bill[1]){
            bill[1] /= 2;
        }else{
            bill[0] /= 2;
        }

        answer++;
    }

    return answer;
}