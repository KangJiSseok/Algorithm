let fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

const [N, M, R] = input[0].split(" ").map(Number);
const arr = input.slice(1);
const graph = Array.from({ length: N + 1 }, () => []);
const visited = Array(N + 1).fill(false);
const visitedOrder = Array(N+1).fill(0);

for (const v of arr) {
  let [a, b] = v.split(" ").map(Number);
  graph[a].push(b);
  graph[b].push(a);
}

for (const arr of graph) {
  arr.sort((a, b) => a - b);
}


function bfs(start) {
  let count = 1;
  const queue = [start];
  visited[start] = true;
  visitedOrder[start] = count++;

  while (queue.length) {
    const node = queue.shift();
    for (const v of graph[node]) {
      if (!visited[v]) {
        visitedOrder[v] = count++;
        queue.push(v);
        visited[v] = true;
      }
    }
  }

  visitedOrder.push(0);
  return 0;
}

bfs(R);

const result = [];
for (let i = 1; i <= N; i++) {
  result.push(visitedOrder[i]);
}

console.log(result.join("\n"));