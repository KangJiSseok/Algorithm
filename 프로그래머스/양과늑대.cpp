#include <vector>
#include <algorithm>

using namespace std;

vector<vector<int>> graph;
vector<int> inf;
int best = 0;

// 지금까지 먹은 양, 늑대 , 갈 수 있는 후보 목록
void dfs(int sh, int wo, vector<int> next) {
    best = max(best, sh);

    for (int i = 0; i < next.size(); i++) {
        int cur = next[i];

        vector<int> nn = next;
        nn.erase(nn.begin() + i);

        for (int c : graph[cur]) {
            nn.push_back(c);
        }

        //양이면 바로 먹기
        if (inf[cur] == 0) {
            dfs(sh + 1, wo, nn);
        }
        //늑대
        else {
            if (wo + 1 < sh) {
                dfs(sh, wo + 1, nn);
            }
        }
    }
}

int solution(vector<int> info, vector<vector<int>> edges) {
    int n = info.size();

    inf = info;
    graph.assign(n, {});

    for (auto e : edges) {
        graph[e[0]].push_back(e[1]);
    }

    vector<int> start;
    for (int c : graph[0]) {
        start.push_back(c);
    }

    dfs(1, 0, start);

    return best;
}