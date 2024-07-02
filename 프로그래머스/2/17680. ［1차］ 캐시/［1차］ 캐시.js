function solution(cacheSize, cities) {
    var answer = 0;
    
    let deque = [];
    
    for(let i=0; i<cities.length; i++){
        const findIndex = deque.indexOf(cities[i].toUpperCase());
        
        if(cacheSize === 0) {
            answer = 5*cities.length;
            break;
        }
        
        if(findIndex === -1) {
            if(deque.length >= cacheSize){
                deque.pop();   
            }
            deque.unshift(cities[i].toUpperCase());
            answer +=5;
        }else{
            deque.splice(findIndex,1);
            deque.unshift(cities[i].toUpperCase());
            answer +=1;   
        }   
    }
    return answer;
}