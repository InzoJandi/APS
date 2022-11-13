const fs = require('fs');
const stdin = fs.readFileSync('/dev/stdin').toString().split('\n');

const splited = stdin[0].split(' ').map((el) => Number(el));
const N = splited[0];
const T = splited[1];
const C = splited[2];
const P = splited[3];

const solution = () => {
	if ((N % T) === 0) {
		console.log(Math.floor(N / T - 1) * C * P);
	} else {
		console.log(Math.floor(N / T) * C * P);	
	}
}
solution();
