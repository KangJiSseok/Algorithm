#include <string>
#include <vector>

using namespace std;

int cnt = 0;
bool isFalse = false;
void dfs(int depth, string word, string arr){
    if(isFalse) return;
    cnt++;
    if(arr == word){
        isFalse = true;
        return;
    }

    if(depth == 5) return;
    dfs(depth + 1, word, arr + "A");
    dfs(depth + 1, word, arr + "E");
    dfs(depth + 1, word, arr + "I");
    dfs(depth + 1, word, arr + "O");
    dfs(depth + 1, word, arr + "U");
}


int solution(string word) {
    dfs(0, word, "");
    return cnt - 1;
}