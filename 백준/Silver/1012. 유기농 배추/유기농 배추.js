const fs = require("fs");
const input = require("fs")
  .readFileSync("dev/stdin")
  .toString()
  .trim()
  .split("\n");

const T = +input.shift();
const inputArr = input.map((v) => v.split(" ").map(Number));

const dx = [-1 ,0, 0, 1];
const dy = [0, -1, 1, 0];


function dfs(farm,visited,y,x, N, M){
  visited[y][x] = true;

  for(let i=0; i<4; i++){
    const nextY = y + dy[i];
    const nextX = x + dx[i];

    if(0<=nextY && nextY < N && 0<=nextX && nextX < M  && farm[nextY][nextX] == 1){
      if(!visited[nextY][nextX]){
        dfs(farm, visited, nextY, nextX, N, M);
      }
    }
  }
}

for (let i = 0; i < T; i++) {
  //make map
  let answer = 0;

  let [M, N, K] = inputArr.shift();
  farm = Array.from(Array(N), () => new Array(M).fill(0));
  visited = Array.from(Array(N), () => new Array(M).fill(false));

  while (K > 0) {
    K--;
    const [x, y] = inputArr.shift();
    farm[y][x] = 1;
  }

  for(let i=0; i<N; i++){
    for(let k=0; k<M; k++){
      if(visited[i][k] == false && farm[i][k] == 1){
        answer++;
        dfs(farm,visited,i,k, N,M);
      }
    }
  }

  console.log(answer);

  // for(let i= 0 ; i<N; i++){
  //   let sb = "";
  //   for(let k=0; k<M; k++){
  //     sb += farm[i][k] + " ";
  //   }
  //   console.log(sb);
  // }
}