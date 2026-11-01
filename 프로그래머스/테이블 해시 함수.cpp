#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> data, int col, int row_begin, int row_end) {
    int answer = 0;

    sort(data.begin(), data.end(), 
        [col](const vector<int> &a, const vector<int> &b){
            if(a[col - 1] == b[col - 1]){
                return a[0] > b[0];
            }
            return a[col - 1] < b[col - 1];
        });

    vector<int> sumList;

    for(int i = row_begin -1; i <= row_end - 1; i++){
        int sum = 0;
        vector<int> &list = data[i];
        for(int &a : list){
            sum += a % (i + 1);
        }

        sumList.push_back(sum);
    }

    int x = sumList[0];

    for(int i = 1; i < sumList.size(); i++){
        x = x ^ sumList[i];
    }
    
    answer = x;

    return answer;
}