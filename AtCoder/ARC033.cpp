#include <array>
#include <iostream>
#include <random>
#include <vector>

using namespace std;

class IndexedSkipList {
private:
    static constexpr int MAX_LEVEL = 24;

    struct Node {
        int value = 0;
        array<int, MAX_LEVEL> next{};
        array<int, MAX_LEVEL> span{};
    };

    vector<Node> nodes;
    int used = 0;
    int levelCount = 1;
    int size = 0;
    mt19937 randomEngine{random_device{}()};
    bernoulli_distribution coinFlip{0.5};

    int randomLevel() {
        int level = 1;
        while (level < MAX_LEVEL && coinFlip(randomEngine)) {
            ++level;
        }
        return level;
    }

public:
    IndexedSkipList(int maxInsertions) : nodes(maxInsertions + 1) {}

    void insert(int value) {
        array<int, MAX_LEVEL> update{};
        array<int, MAX_LEVEL> rank{};

        int current = 0;  // 0번 노드는 head
        for (int level = levelCount - 1; level >= 0; --level) {
            rank[level] = (level == levelCount - 1) ? 0 : rank[level + 1];
            while (nodes[current].next[level] != 0 &&
                   nodes[nodes[current].next[level]].value < value) {
                rank[level] += nodes[current].span[level];
                current = nodes[current].next[level];
            }
            update[level] = current;
        }

        int newLevel = randomLevel();
        if (newLevel > levelCount) {
            for (int level = levelCount; level < newLevel; ++level) {
                rank[level] = 0;
                update[level] = 0;
                nodes[0].span[level] = size;
            }
            levelCount = newLevel;
        }

        int newNode = ++used;
        nodes[newNode].value = value;

        for (int level = 0; level < newLevel; ++level) {
            int distance = rank[0] - rank[level];

            nodes[newNode].next[level] = nodes[update[level]].next[level];
            nodes[newNode].span[level] = nodes[update[level]].span[level] - distance;

            nodes[update[level]].next[level] = newNode;
            nodes[update[level]].span[level] = distance + 1;
        }

        for (int level = newLevel; level < levelCount; ++level) {
            ++nodes[update[level]].span[level];
        }
        ++size;
    }

    int eraseKth(int k) {
        array<int, MAX_LEVEL> update{};
        int current = 0;
        int passed = 0;

        for (int level = levelCount - 1; level >= 0; --level) {
            while (nodes[current].next[level] != 0 &&
                   passed + nodes[current].span[level] < k) {
                passed += nodes[current].span[level];
                current = nodes[current].next[level];
            }
            update[level] = current;
        }

        int target = nodes[update[0]].next[0];
        int result = nodes[target].value;

        for (int level = 0; level < levelCount; ++level) {
            if (nodes[update[level]].next[level] == target) {
                nodes[update[level]].span[level] += nodes[target].span[level] - 1;
                nodes[update[level]].next[level] = nodes[target].next[level];
            } else {
                --nodes[update[level]].span[level];
            }
        }

        while (levelCount > 1 && nodes[0].next[levelCount - 1] == 0) {
            --levelCount;
        }
        --size;
        return result;
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int q;
    cin >> q;

    IndexedSkipList skipList(q);

    while (q--) {
        int type, x;
        cin >> type >> x;

        if (type == 1) {
            skipList.insert(x);
        } else {
            cout << skipList.eraseKth(x) << '\n';
        }
    }
}
