function solution(begin, target, words) {
    let result = 0;
    const queue = [];
    const visited = [];
    
    if (!words.includes(target)) return result;
    
    queue.push([begin, result]);
    
    while (queue) {
        let [cur, cnt] = queue.shift();
        
        if (cur === target) {
            return cnt;
        }
        
        words.forEach((word) => {
            let diff = 0;
            
            if (visited.includes(word)) return;
            
            for (let i = 0; i < words.length; i++) {
                if (word[i] !== cur[i]) diff++;
            }
            
            if (diff === 1) {
                queue.push([word, ++cnt]);
                visited.push(word);
            }
        })
    }
    return result;
}
