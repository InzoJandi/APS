function solution(priorities, location) {
    const arr = priorities.map((priority, index) => {
        return {
            index,
            priority,
        }
    })
    
    const queue = [];
    
    while (arr.length > 0) {
        const n = arr.shift();
        const isMax = arr.some((el) => el.priority > n.priority);
        
        if (isMax) {
            arr.push(n);
        } else {
            queue.push(n);
        }
    }
    return queue.findIndex((el) => el.index === location) + 1;
}
