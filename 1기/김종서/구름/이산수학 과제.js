const fs = require('fs');
const stdin = fs.readFileSync('/dev/stdin').toString().split('\n');
const n = Number(stdin[0]);

const solution = () => {
	let sum = 0;
	let temp = 0;
	
	for (let i = 1; i <= n; i++) {
		sum += i;
		
		if (sum >= n) {
			temp = i;
			break;
		} 
	}
	
	const result = [];
	for (let i = sum - temp + 1; i <= sum; i++) {
		result.push(i);
	}
	
	console.log(temp - result.indexOf(n), 1 + result.indexOf(n));
};
solution();
