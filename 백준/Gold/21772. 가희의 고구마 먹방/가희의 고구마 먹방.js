const { count } = require('console');
let fs = require('fs');
let input = fs.readFileSync('dev/stdin').toString().split('\n');
// let input = fs.readFileSync('예제.txt').toString().split('\n');
const [R,C,T] = input[0].split(" ").map((x) => +x);

const array =[];
const visit = [];
let startX = 0;
let startY = 0;
let max = 0;

const dx = [1, 0, 0, -1];
const dy = [0, 1, -1, 0];


function init(){
    for(let i=0; i<R; i++){
        const arr = input[i + 1].split("").map((x) => x.toString());
        array[i] = [];
        visit[i] = [];
        for(let k=0; k<C; k++){
            if(arr[k] === 'G'){
                arr[k] = '.';
                startX = k;
                startY = i;
            }
            array[i][k] = arr[k];
            visit[i][k] = false;
        }
    }
}

function display(){
    let sb = "";
    for(let i=0; i<R; i++){
        for(let k=0; k<C; k++){
            sb += array[i][k]+ " ";
        }
        sb += '\n';
    }
    console.log(sb);
}

function dfs(y, x, time, count){

    if(time === 0) {
        max = Math.max(max,count);
        return;
    }

    visit[y][x] = true;

    for(let i=0; i<4; i++){
        const nextY = y + dy[i];
        const nextX = x + dx[i];

        if(0<=nextY && nextY<R && 0<=nextX && nextX <C && array[nextY][nextX] !== '#'){
        
            //방문을 한곳이면
            if(visit[nextY][nextX]){
                dfs(nextY,nextX,time - 1, count);
            }
            //방문을 안한곳이면
            else{
                if(array[nextY][nextX] ==='S'){
                    dfs(nextY,nextX,time - 1,count + 1);
                    visit[nextY][nextX] = false;
                }
                else{
                    dfs(nextY,nextX,time - 1,count);
                }
            }
        }
    }
}

init();
dfs(startY, startX, T, 0);
console.log(max);
// display();
