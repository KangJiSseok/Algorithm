#include <iostream>
#include <vector>
#include <algorithm>

class Solution {
    int parent[200001];
public:
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {

        // 0based
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        for(int i =0; i< edges.size(); i++ ){
            uni(edges[i][0], edges[i][1]);
        }

        if(find(parent[source]) == find(parent[destination])){
            return true;
        }else{
            return false;
        }

        return false;
    }

    void uni(int a, int b){
        int A = find(a);
        int B = find(b);

        if ( A == B ) return;
        if(A < B){
            parent[B] = A;
        }else{
            parent[A] = B;
        }
    }

    int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
};