let fs = require('fs');
let input = fs.readFileSync('dev/stdin').toString().split('\n');
// let input = fs.readFileSync('예제.txt').toString().split('\n');
const [N,M] = input[0].split(" ").map((x) => +x);

const array =[];
const visit =[];
let resultSize = 0;
let resultCount =0;

const dx = [-1, 0, 0, 1];
const dy = [0, -1, 1, 0];


function init(){
    for(let i=0; i<N; i++){
        const arr = input[i + 1].split(" ").map((x) => +x);
        array[i] = [];
        visit[i] = [];
        for(let k=0; k<M; k++){
            array[i][k] = arr[k];
            visit[i][k] = false;
        }
    }
}

function display(){
    let sb = "";
    for(let i=0; i<N; i++){
        for(let k=0; k<M; k++){
            sb += array[i][k]+ " ";
        }
        sb += '\n';
    }
    console.log(sb);
}


function bfs(y, x){
    let queue = [];
    visit[y][x] = true;
    queue.unshift([y,x]);
    let max =0;

    while(queue.length !=0){
        const current = queue.pop();
        max++;
        for(let i=0; i< 4; i++){
            const currentY = current[0] + dy[i];
            const currentX = current[1] + dx[i];

            if(0 <= currentY && currentY < N && 0 <= currentX && currentX < M){
                if (!visit[currentY][currentX] && array[currentY][currentX] == 1) {
                    queue.unshift([currentY, currentX]);
                    visit[currentY][currentX] = true;
                }
            }
        }
    }
    resultSize = Math.max(max,resultSize);
}

function main(){
    init();

    for(let i=0; i<N; i++){
        for(let j=0; j<M; j++){
            if(!visit[i][j] && array[i][j] == 1) {
                resultCount++;
                bfs(i,j);
            }
        }
    }

    console.log(resultCount);
    console.log(resultSize);
}

main();