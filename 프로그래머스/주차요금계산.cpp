#include <map>
#include <sstream>
#include <string>
#include <vector>
#include <cmath>

using namespace std;

vector<int> solution(vector<int> fees, vector<string> records) {

    map<string, int> car;   //입차시간
    map<string, int> total; //누적시간

    for(string record : records){
        stringstream ss(record);

        string t, num, io;
        ss >> t >> num >> io;
        
        int time = (stoi(t.substr(0,2)) * 60 + stoi(t.substr(3,2)));
        
        if(io == "IN"){
            car[num] = time;
        }else{
            total[num] += time - car[num];
            car.erase(num);
        }
    }

    //출차 안한차들
    for(auto [car, time]: car){
        total[car] += 23 * 60 + 59 - time;
    }


    vector<int> answer;

    for(auto [car, time]: total){
        if(time <= fees[0]){
            answer.push_back(fees[1]);
            continue;
        }

        int cal = fees[1] + ceil(((double)time - fees[0]) / fees[2]) * fees[3];
        answer.push_back(cal);
    }

    return answer;
}