#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

typedef long long ll;


vector<int> solution(int n, ll k) {
    vector<int> nums, answer;

    for (int i = 1; i <= n; i++) {
        nums.push_back(i);
    }

    ll fac = 1;
    for (int i = 2; i < n; i++) fac *= i;

    for (int i = 1; i <= n; i++) {
        int idx = (k - 1) / fac;

        answer.push_back(nums[idx]);
        nums.erase(nums.begin() + idx);

        k = (k - 1) % fac + 1;
        if (i < n) fac /= n - i;
    }

    return answer;
}