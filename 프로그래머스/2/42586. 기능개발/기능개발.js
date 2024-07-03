function solution(progresses, speeds) {
    
    const queue = [];
    
    for(let i=0; i<progresses.length; i++){
        let remainder = 0;
        if((100 - progresses[i]) % speeds[i] == 0) {
            remainder = (100 - progresses[i]) / speeds[i];   
        }
        else{
            remainder = Math.ceil((100 - progresses[i]) / speeds[i]);
        }
        queue.unshift(remainder);
    }
    
    // console.log(queue);
    
    var answer = [];
    while(queue.length > 0){

        let max = queue.pop();
        let count = 1;

        while(queue[queue.length - 1] <= max && queue.length > 0){
            queue.pop();
            count++;
        }
        answer.push(count);
    }

    return answer;
}
