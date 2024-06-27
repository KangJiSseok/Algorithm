function solution(babbling) {
    let answer = 0;
    const speak = ['aya', 'ye', 'woo', 'ma'];
    
    for(let i=0; i< babbling.length; i++){
        let text = babbling[i];
        for(let j=0; j<speak.length; j++){
            text = text.replace(speak[j],'-');
        }
        
        text = text.replace(/[\-]/g, '');
        if(text.length === 0) {
            answer++;
        }
    }
    
    return answer;
}