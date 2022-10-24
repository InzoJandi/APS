const fs = require('fs');
const stdin = fs.readFileSync('/dev/stdin').toString().split('\n');
const data = stdin[1].split(' ').map((el) => Number(el));

const solution = () => {
	const result = data.reduce((cur, acc) => cur + acc, 0);
	
	console.log(result);
}
solution();
