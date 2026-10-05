#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int toMinutes(string str){
    return stoi(str.substr(0,2)) * 60 + stoi(str.substr(3,2));
}

int solution(vector<vector<string>> book_time) {
    int answer = 0;

    vector<pair<int, int>> s;

    for(int i =0; i< book_time.size(); i++){
        int a = toMinutes(book_time[i][0]);
        int b = toMinutes(book_time[i][1]);

        s.push_back({a , 1});
        s.push_back({b + 10, -1});
    }

    sort(s.begin(), s.end());

    int rooms = 0;

    for(auto [time, room]: s){
        rooms += room;
        answer = max(answer, rooms);
    }

    return answer;
}