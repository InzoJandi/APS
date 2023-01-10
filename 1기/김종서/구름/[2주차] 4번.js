// Run by Node.js
const fs = require('fs');
const stdin = fs.readFileSync('/dev/stdin').toString().split('\n');

const line = Number(stdin.shift().split(' ')[0]); // 3
let result = 0;

const solution = () => {
	for (const n of stdin) {
		const n1 = Number(n.split(' ')[0]);
		const n2 = Number(n.split(' ')[1]);
		
		if (line === 1) {
			result++;
		} else if (line === 2) {
			result += 3;
		} else {
		if ((n1 === 1 || n1 === line) && (n2 === 1 || n2 === line)) {
			result += 3;
		} else if ((n1 === 1 || n1 === line) || (n2 === 1 || n2 === line)) {
			result += 4;
		} else {
			result += 5;
		}
		}
	}
	console.log(result);
}

solution();
