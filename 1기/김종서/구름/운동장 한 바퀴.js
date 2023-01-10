const fs = require('fs');
const stdin = fs.readFileSync('/dev/stdin').toString().split('\n');
const d1 = Number(stdin[0]);
const d2 = Number(stdin[1]);
const p = 3.141592;

const solution = () => {
	const result = (d1 * 2) + (p * d2 * 2);
	console.log(result);
} 
solution();
