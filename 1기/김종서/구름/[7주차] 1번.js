const fs = require('fs');
const stdin = fs.readFileSync('/dev/stdin').toString().split('\n');
const data = stdin.slice(1).map((el) => el.split(' ').slice(1));

const solution = () => {
	const obj = {};
	let result = [];
	
	data.forEach((el) => {
		el.forEach((e) => {
			if (!obj[e]) obj[e] = 1;
			else obj[e] += 1;
		})
	})
	
	const sorted = Object.entries(obj).sort((a, b) => b[1] - a[1]).sort((a, b) => {
		if (a[1] === b[1]) {
			return Number(b[0]) - Number(a[0])
		};
	})
	const max = sorted[0][1];
	
	for (const [a, b] of sorted) {
		if (max === b) result.push(a);
	}
	console.log(result.join(' '))
}
solution();
