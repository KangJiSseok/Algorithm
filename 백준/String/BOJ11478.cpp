#include <iostream>
#include <unordered_set>
#include <string>
using namespace std;

int main() {
    string s;
    cin >> s;

    int n = s.size();
    int answer = 0;

    for (int length = 1; length <= n; ++length) {
        unordered_set<string> substrings;

        for (int start = 0; start + length <= n; start++) {
            substrings.insert(s.substr(start, length));
        }

        answer += substrings.size();
    }

    cout << answer;
}