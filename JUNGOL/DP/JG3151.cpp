#include <iostream>
#include <vector>

using namespace std;
typedef long long ll;
const int INF = 1e9;

string strA, strB;
int dp[1001][1001];

bool calculator(){
    fill(&dp[0][0], &dp[0][0] + 1001 * 1001, 0);

    int sizeA = strA.size();
    int sizeB = strB.size();

    int cnt = 0;
    for(int i = 0 ; i< sizeA; i++){
        if('A' <= strA[i] && strA[i] <= 'Z') cnt++;
    }

    // 소문자는 스킵 가능하지만 대문자를 만나면 그 뒤로는 영원히 불가능(-INF)
    for(int j = 1; j <= sizeA; j++){
        if('a' <= strA[j - 1] && strA[j - 1] <= 'z') dp[0][j] = dp[0][j - 1];
        else dp[0][j] = -INF;
    }

    for(int i = 1; i <= sizeB; i++){
        for(int j = 1; j <= sizeA; j++){
            //1. strB = 대문자, strA = 대문자 && strB = 소문자, strA = 소문자
            //2. strB = 대문자, strA = 소문자
            if(strB[i - 1] == strA[j - 1] || strB[i - 1] == strA[j - 1] - 32){
                dp[i][j] = dp[i - 1][j - 1] + 1;
            }
            if('a' <= strA[j-1] && strA[j-1] <= 'z'){
                if(dp[i][j-1] >= 1) dp[i][j] = max(dp[i][j], dp[i][j-1]);
                }
        }
    }

    for(int i =0 ; i <= sizeB; i++){
        cout << "\n";
        for(int j = 0; j <= sizeA; j++){
            cout << dp[i][j] << "   ";
        }
    }


    if(dp[sizeB][sizeA] >= sizeB && dp[sizeB][sizeA] >= cnt) return true;

    return false;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);


    int T;
    cin >> T;
    for(int i =0; i< T; i++){
        cin >> strA >> strB;
        if(calculator()){
            cout <<"YES" << "\n";
        }else{
            cout <<"NO" << " \n";
        }
    }

    return 0;
}
