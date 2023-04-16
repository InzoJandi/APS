/*
 * Programers
 * https://school.programmers.co.kr/learn/courses/30/lessons/150368
 * Problem Number: 150368
 * Level: 2
 * Algorithm: DFS
 */

function solution(users, emoticons) {
    const answer = [0, 0];
    const discount = [10, 20, 30, 40];
        
    const arr = [];
    
    function dfs(emoticons, result) {
    
        if (emoticons.length < 1) {
            arr.push(result);
            return;
        }
       
        for (let i=0; i<discount.length; i++) {
            
        dfs(emoticons.slice(1), [...result, [discount[i], emoticons[0]]]);
        }
    }
    
    dfs(emoticons, []);
    
    const disAmt = (dis, price) => (100-dis) / 100 * price;
    
    arr.forEach(disArr => {
    
        const accrue = [0, 0]
        
        users.forEach(([per, price]) => {
            let sum = 0;
            disArr.forEach(([dis, cost]) => {
                if(dis >= per) {
                    sum += disAmt(dis, cost);
                }
            });
            
            if(sum >= price) {
                accrue[0] += 1;  
            } else { 
                accrue[1] += sum;
            }
        });
        
        if(answer[0] < accrue[0]) {
            answer[0] = accrue[0];
            answer[1] = accrue[1];
        } else if(answer[0] === accrue[0]) {
            if(answer[1] < accrue[1]) {
                answer[1] = accrue[1];
            }
        }
        
    }); 
    return answer;
}