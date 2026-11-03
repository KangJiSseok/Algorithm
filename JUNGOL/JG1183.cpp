#include <iostream>
#include <vector>
#include <map>

using namespace std;

int W;
map<int, int, greater<int>> arr;
int arr1[6];
int arr2[6];


int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> W;

    int coin = 0;
    int a;
    
    cin >> a;
    arr[500] = a;
    arr1[0] = a;
    coin += 500 * a;

    cin >> a;
    arr[100] = a;
    arr1[1] = a;
    coin += 100 * a;

    cin >> a;
    arr[50] = a;
    arr1[2] = a;
    coin += 50 * a;

    cin >> a;
    arr[10] = a;
    arr1[3] = a;
    coin += 10 * a;

    cin >> a;
    arr[5] = a;
    arr1[4] = a;
    coin += 5 * a;

    cin >> a;
    arr[1] = a;
    arr1[5] = a;
    coin += 1 * a;


    int C = coin - W;

    map<int, int, greater<int>> cnt;
    int idx = 0;
    for(auto[key , value] : arr){
        int m = key * value;
        if(C >= m){
            arr2[idx++] = value;
            C -= key * value;
        }else{
            int ccnt = C / key;
            arr2[idx++] = ccnt;
            C -= key * ccnt;
        }
    }

    int CNT = 0;
    for(int i =0; i< 6; i++){
        CNT += arr1[i] - arr2[i];
    }

    cout << CNT << "\n";
    for(int i =0; i< 6; i++){
        cout << arr1[i] - arr2[i] << " ";
    }

}
// 3200 -> 500 * 6   500 : 5개밖에 없으면 ?
// 2000 -> 500 5


/**
1   2   3   4   5   6   7   8   9   10  11  12  13
                                    1
                1                   2           

15 + 4 = 19

비싼걸 최대한 많이 뽑아야함.
19 - 13 = 6
1 1
*/