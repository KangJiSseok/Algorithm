function solution(N, stages) {
    
    let people = stages.length;
    let stageSort = stages.sort();
    // console.log(stageSort);
    const fail = {};
    
    for(let i=0; i< stages.length; i++){
        if(fail[stageSort[i]]){
            fail[stageSort[i]]++;
        }else{
            fail[stageSort[i]] = 1;
        }
    }
    
    
    let failResult = [];
    for(let i=1; i<=N; i++){        
        if(fail[i]){
            failResult.push({st : i, fa : fail[i]/people})
            people = people - fail[i];   
        }else{
            failResult.push({st : i, fa : 0})
        }        
    }
    
    failResult.sort((a,b) => b.fa - a.fa);
    // console.log(failResult);
    
    var answer = [];
    let i =0;
    for(let st in failResult){
        answer[i] = failResult[st].st;
        i++;
    }
    return answer;
}