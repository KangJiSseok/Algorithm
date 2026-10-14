#include <iostream>
#include <algorithm>
#include <vector>


using namespace std;


int K;
int A, B;

vector<int> a;
vector<int> b;

int arrA[2'000'001];
int arrB[2'000'001];

int main(){

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> K;
    cin >> A >> B;

    for(int i =0; i < A; i++){
        int c;
        cin >> c;
        a.push_back(c);
    }

    for(int i =0; i < B; i++){
        int c;
        cin >> c;
        b.push_back(c);
    }


    for(int i=0; i< A; i++){
        int sum = 0;
        for(int j = 0; j < A - 1; j++){
            sum += a[(i + j) % A];
            arrA[sum]++;
        }
    }


    int total = 0;
    for(int price : a) total += price;
    arrA[total]++;

    for(int i = 0; i < B; i++){
        int sum = 0;
        for(int j = 0; j < B - 1; j++){
            sum += b[(i + j) % B];
            arrB[sum]++;
        }
    }

    total = 0;
    for(int price : b) total += price;
    arrB[total]++;

    long long answer = 0;
    arrA[0] = 1;
    arrB[0] = 1;
    for(int i = 0; i <= K; i++){
        int cntA = arrA[i];
        int cntB = arrB[K - i];
        answer += 1LL * cntA * cntB;
    }

    cout << answer;

}