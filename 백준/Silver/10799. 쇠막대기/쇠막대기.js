let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');
const text = input[0].split('').map((x) => x.toString());
const stack = [];


function display() {
    let stackText = "";
    for(let i=0; i <stack.length; i++){
        stackText += stack[i];
    }
    console.log(stackText);
}


function solution(){
    let result = 0;
    for(let i=0; i<text.length; i++){
        
        if(text[i] === '('){
            stack.push(text[i]);
        }
        else{
            if(text[i-1] === '('){
                stack.pop();
                result += stack.length;
            }else{
                stack.pop();
                result++;
            }
        }

    }

    console.log(result);
}

solution();
