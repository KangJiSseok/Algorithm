let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');
const [H, W] = input[0].split(" ").map((x) => +x);
const height = input[1].split(" ").map((x) => +x);

function solution() {
    let leftIndex = 0;
    let rightIndex = W - 1;
    let leftMax = 0;
    let rightMax = 0;
    let result = 0;

    while (leftIndex <= rightIndex) {
        if (height[leftIndex] <= height[rightIndex]) {
            if (height[leftIndex] >= leftMax) {
                leftMax = height[leftIndex];
            } else {
                result += leftMax - height[leftIndex];
            }
            leftIndex++;
        } else {
            if (height[rightIndex] >= rightMax) {
                rightMax = height[rightIndex];
            } else {
                result += rightMax - height[rightIndex];
            }
            rightIndex--;
        }
    }

    return result;
}

console.log(solution());