function solution(clothes) {
    var answer = 1;    
    let map = {};
    
    for(let type of clothes){
        if(map[type[1]]){
            map[type[1]]++;
        }else{
            map[type[1]] = 1;
        }
    }
    
    for(let value in map){
        answer *= map[value] + 1
    }
    
    

    return answer-1;
}