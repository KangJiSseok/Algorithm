function solution(n, left, right) {
    
    var answer = [];
    
    for(let i= left; i<= right; i++){
        answer[i - left] = Math.max((Math.floor(i/n)), i%n)+1;
    }

    return answer;
}