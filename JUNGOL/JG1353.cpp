#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    int M;
    cin >> N >> M;

    vector<int> numbers(N);
    for (int i = 0; i< N; i++) cin >> numbers[i];

    sort(numbers.begin(), numbers.end());

    int left = 0;
    int right = N - 1;
    int answer = 0;

    while (left < right) {
        int sum = numbers[left] + numbers[right];

        if (sum == M) {
            answer++;
            left++;
            right--;
        } else if (sum < M) {
            left++;
        } else {
            right--;
        }
    }

    cout << answer;
}