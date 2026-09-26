#include <algorithm>
#include <queue>
#include <utility>
#include <vector>

using namespace std;

int dy[4] = {-1, 0, 0, 1};
int dx[4] = {0, -1, 1, 0};
bool visited[50][50];

void normalize(vector<pair<int, int>>& shape) {
    int minY = shape[0].first;
    int minX = shape[0].second;

    for (auto [y, x] : shape) {
        minY = min(minY, y);
        minX = min(minX, x);
    }

    for (auto& [y, x] : shape) {
        y -= minY;
        x -= minX;
    }

    sort(shape.begin(), shape.end());
}

// 90도 회전 후 정규화
void rotateShape(vector<pair<int, int>>& shape) {
    for (auto& [y, x] : shape) {
        int oldY = y;
        y = x;
        x = -oldY;
    }

    normalize(shape);
}

// BFS로 덩어리 추출
vector<vector<pair<int, int>>> step1(
    const vector<vector<int>>& board, int num
) {
    int n = board.size();
    vector<vector<pair<int, int>>> shapes;

    for (int i = 0; i < n; i++)
        fill(visited[i], visited[i] + n, false);

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (visited[i][j] || board[i][j] != num)
                continue;

            queue<pair<int, int>> q;
            vector<pair<int, int>> shape;

            q.push({i, j});
            visited[i][j] = true;

            while (!q.empty()) {
                auto [y, x] = q.front();
                q.pop();
                shape.push_back({y, x});

                for (int d = 0; d < 4; d++) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];

                    if (ny < 0 || ny >= n || nx < 0 || nx >= n)
                        continue;
                    if (visited[ny][nx] || board[ny][nx] != num)
                        continue;

                    visited[ny][nx] = true;
                    q.push({ny, nx});
                }
            }

            shapes.push_back(shape);
        }
    }

    return shapes;
}

int solution(vector<vector<int>> game_board,
             vector<vector<int>> table) {
    auto shapes = step1(game_board, 0);
    auto inputShapes = step1(table, 1);

    for (auto& shape : shapes)
        normalize(shape);

    vector<bool> used(inputShapes.size(), false);
    int answer = 0;

    for (const auto& hole : shapes) {
        for (int i = 0; i < inputShapes.size(); i++) {
            if (used[i] || hole.size() != inputShapes[i].size())
                continue;

            auto piece = inputShapes[i];
            bool matched = false;

            
            for (int d = 0; d < 4; d++) {
                rotateShape(piece);

                if (hole == piece) {
                    matched = true;
                    break;
                }
            }

            if (matched) {
                used[i] = true;
                answer += hole.size();
                break;
            }
        }
    }

    return answer;
}