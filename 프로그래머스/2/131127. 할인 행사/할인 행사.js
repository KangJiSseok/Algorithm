function solution(want, number, discount) {
    var answer = 0;
    let array = {};
    

    for(let i=0; i<want.length; i++){
        array[want[i]] = number[i];
    }


    for(let i=0; i<= discount.length - 10; i++){
        let compare = {};
        let valid = true;
        for (let k = i; k < i + 10; k++) {
            if (compare[discount[k]]) {
                compare[discount[k]]++;
            } else {
                compare[discount[k]] = 1;
            }
        }


        for (let k = 0; k < want.length; k++) {

            if(compare[want[k]] !== array[want[k]]){
                valid = false;   
            }
            
        }

        if(valid) answer++;

    }

    return answer;
}
