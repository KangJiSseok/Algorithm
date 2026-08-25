#include <string>
#include <vector>
#include <format>

using namespace std;

int to_second(string s){
    vector<string> a;
    int pos;
    int cur_pos = 0;
    while((pos = s.find(":", cur_pos)) != string::npos){
        int len = pos - cur_pos;
        string str = s.substr(cur_pos, len);
        cur_pos = pos + 1;
        a.push_back(str);
    }
    a.push_back(s.substr(cur_pos));

    return stoi(a[0]) * 60 + stoi(a[1]);
};

string sec_to_string(int a){
    int m = a / 60;
    int s = a % 60;

    return format("{:02}:{:02}", m, s);
}

string solution(string video_len, string pos, string op_start, string op_end, vector<string> commands) {
    
    int a = to_second(video_len);
    int b = to_second(pos);
    int c = to_second(op_start);
    int d = to_second(op_end);

    int cur_pos = b;

    for(string com : commands){
        if(c <= cur_pos && cur_pos <= d){
            cur_pos = d;
        }
        if(com == "prev"){
            cur_pos = max(0, cur_pos - 10);
        }else if(com == "next"){
            cur_pos = min(a, cur_pos + 10);
        }
    }

    if(c <= cur_pos && cur_pos <= d){
        cur_pos = d;
    }

    return sec_to_string(cur_pos);
    
}