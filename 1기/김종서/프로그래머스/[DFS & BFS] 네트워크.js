function solution(n, computers) {
    const visited = new Array(n).fill(false);
    let result = 0;

    function dfs(i) {
        visited[i] = true;

        for (let j = 0; j < computers[i].length; j++) {
            if (computers[i][j] && !visited[j]) {
                dfs(j);
            }
        }
    }

    for (let i = 0; i < computers.length; i++) {
        if (!visited[i]) {
            dfs(i);
            result++;
        }
    }
    return result;
}
