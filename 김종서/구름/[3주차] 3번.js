const fs = require('fs');
const stdin = fs.readFileSync('/dev/stdin').toString().split('\n');
const island = Number(stdin[0].split(' ')[0]);
const k = Number(stdin[0].split(' ')[2]);
const bridge = stdin.filter((el) => el.split(' ').length === 2).map((el) => el.split(' '));

const solution = () => {	
	const obj = {};
	
	for (const el of bridge) {
		const [x, y] = el;
		
		if (!obj[x]) {
			obj[x] = [y];
		} else {
			obj[x].push(y);
		}
		
		if (!obj[y]) {
			obj[y] = [x];
		} else {
			obj[y].push(x);
		}
	}

	const visited = new Array(island + 1).fill(-1);
	const queue = [];
	queue.push(1);
	visited[1] = 0;

	while (queue.length > 0) {
		const cur = queue.shift();
		
		for (const next of obj[cur]) {
			if (visited[next] !== -1) {
				continue;
			} else {
				queue.push(next);
				visited[next] = visited[cur] + 1;
			}
		}
	}
	
	if (1 <= visited[island] && visited[island] <= k) {
		console.log("YES");
	} else {
		console.log("NO");
	}
}  

solution()

