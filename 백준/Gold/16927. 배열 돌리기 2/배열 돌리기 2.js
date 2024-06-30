let fs = require('fs');
let input = fs.readFileSync('dev/stdin').toString().split('\n');
const [N,M,R] = input[0].split(" ").map((x) => +x);
// const data = input[i].split("").map((x) => x.toString());

const array =[];
const resultArray =[];

function init(){
    for(let i=0; i<N; i++){
        const arr = input[i + 1].split(" ").map((x) => +x);
        array[i] = [];
        resultArray[i] = [];
        for(let k=0; k<M; k++){
            array[i][k] = arr[k];
            resultArray[i][k] = arr[k];
        }
    }
}

function display(){
    let sb = "";
    for(let i=0; i<N; i++){
        for(let k=0; k<M; k++){
            sb += resultArray[i][k]+ " ";
        }
        sb += '\n';
    }
    console.log(sb);
}

function extract(rowStart,rowEnd,columnStart,columnEnd){

    let newArray = [];
    let sb = "";

    let columnIndexAdjust = columnStart;
    let rowIndexAjust = rowStart;
    while(columnIndexAdjust < columnEnd){
        newArray.push(array[columnIndexAdjust++][rowIndexAjust]);
    }

    while(rowIndexAjust < rowEnd){
        newArray.push(array[columnIndexAdjust][rowIndexAjust++]);
    }

    while(columnStart < columnIndexAdjust){
        newArray.push(array[columnIndexAdjust--][rowIndexAjust]);
    }

    while(rowStart < rowIndexAjust){
        newArray.push(array[columnIndexAdjust][rowIndexAjust--]);
    }
    
    return newArray;
}

function rotate(newArray){
    const end = newArray[newArray.length - 1];
    for(let i=newArray.length - 1 ; i >=0 ; i--){
        newArray[i] = newArray[i-1];
    }
    newArray[0] = end;

    return newArray;
}

function make(newArray, rowStart, rowEnd, columnStart, columnEnd){

    let columnIndexAdjust = columnStart;
    let rowIndexAjust = rowStart;
    let i =0;
    while(columnIndexAdjust < columnEnd){
        resultArray[columnIndexAdjust++][rowIndexAjust] = newArray[i++];
    }

    while(rowIndexAjust < rowEnd){
        resultArray[columnIndexAdjust][rowIndexAjust++] = newArray[i++];
    }

    while(columnStart < columnIndexAdjust){
        resultArray[columnIndexAdjust--][rowIndexAjust] = newArray[i++];
    }

    while(rowStart < rowIndexAjust){
        resultArray[columnIndexAdjust][rowIndexAjust--] = newArray[i++];
    }
    
}   

function rotateCount(rowStart, rowEnd, columnStart, columnEnd){
     const k = (columnEnd - columnStart + 1)*2 + (rowEnd - rowStart + 1 - 2)*2
     return R%k;
}

function dfs(rowStart, rowEnd, columnStart, columnEnd){
    if((rowEnd - rowStart) < 1  || (columnEnd - columnStart) < 1){
        return;
    }

    let newArray = extract(rowStart, rowEnd, columnStart, columnEnd);
    const k = rotateCount(rowStart, rowEnd, columnStart, columnEnd)
    for(let i=0; i< k; i++){
        newArray = rotate(newArray);
    }

    make(newArray, rowStart, rowEnd, columnStart, columnEnd);

    dfs(rowStart+1, rowEnd-1, columnStart+1, columnEnd-1)
}


init();
dfs(0,M-1,0,N-1);
display();
// console.log(resultArray);
// display();
// extract(0,3,0,3);
