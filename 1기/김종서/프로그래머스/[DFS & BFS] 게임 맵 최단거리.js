function solution(maps) {
    let result = -1;
    const n = maps.length;
    const m = maps[0].length;
    const visited = maps;
    
    const M = [[1, 0], [-1, 0], [0, 1], [0, -1]];
    
    const validate = (x, y) => {
        return x < 0 || y < 0 || x >= n || y >= m;
    }
    
    const queue = [[0, 0, 1]];
        
    while (queue.length) {
        const [x, y, cnt] = queue.shift();
              
        if (x === n - 1 && y === m - 1) {
            return cnt;
        }
              
        for (const [nx, ny] of M) {
            let X = nx + x;
            let Y = ny + y;
                  
            if (validate(X, Y)) continue;
            if (visited[X][Y]) {
                visited[X][Y] = 0;
                queue.push([X, Y, cnt + 1])
            }
        }
    }
    return result;
}
