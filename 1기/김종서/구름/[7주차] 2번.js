const fs = require('fs');
const stdin = fs.readFileSync('/dev/stdin').toString().split('\n');
const data = stdin.slice(2).map((el) => el.split(' ')).filter((el) => el.length === 2);
const n = Number(stdin[0]);

const solution = () => {
	const matrix = new Array(n + 1).fill(0).map((el) => new Array(n + 1).fill(0));
	
	data.forEach((el) => {
		matrix[el[0]][el[1]] = 1;
		matrix[el[1]][el[0]] = 1;
	})
	
	const visited = new Array(n + 1).fill(false);
	let cnt = 0;
	
	bfs(matrix, 1, visited);
	
	function bfs(matrix, v, visited) {
		const queue = [v];
		visited[v] = true;
		
		while (queue.length !== 0) {
			let cur = queue.pop();
			
			for (let i = 1; i <= matrix[cur].length; i++) {
				if (visited[i] !== true && matrix[cur][i] === 1) {
					queue.unshift(i);
					visited[i] = true;
				}
			}
		}
	}
	console.log(visited.filter((el) => el === true).length)
};
solution();
