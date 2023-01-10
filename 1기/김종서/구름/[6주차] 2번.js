const fs = require('fs');
const stdin = fs.readFileSync('/dev/stdin').toString().split('\n');
const data = stdin[1];

const solution = () => {
	let result = '';
	const arr = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'];
	
	for (let i = 0; i < data.length; i++) {
		if (i % 2 === 0) {
			result += arr[(arr.indexOf(data[i]) + data[i + 1] ** 2) % 26];
		}
	}
	console.log(result);
}
solution();
