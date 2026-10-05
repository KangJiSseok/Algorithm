#include <string>
#include <vector>
#include <queue>
#include <cstring>
#include <map>
#include <algorithm>

using namespace std;

int toMinutes(string &time){
    return stoi(time.substr(0,2)) * 60 + stoi(time.substr(3,2));
}


vector<string> solution(vector<vector<string>> plans) {
    vector<string> answer;

    sort(plans.begin(), plans.end(), [](auto &a, auto &b){
        return a[1] < b[1];
    });

    vector<pair<string, int>> s;

    int now = 0;

    for(vector<string> plan : plans){
        string name = plan[0];
        int start = toMinutes(plan[1]);
        int duration = stoi(plan[2]);

        while(!s.empty() && now < start){
            auto [beforeName, time] = s.back(); s.pop_back();

            int a = start - now;

            if(time <= a){
                now += time;
                answer.push_back(beforeName);
            }else{
                s.push_back({beforeName, time - a});
                now = start;
            }
        }

        s.push_back({name, duration});
        now = start;
    }

    while(!s.empty()){
        auto [beforeName, time] = s.back(); s.pop_back();
        answer.push_back(beforeName);
    }

    return answer;
}
