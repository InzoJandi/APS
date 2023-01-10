const fs = require('fs');
const stdin = fs.readFileSync('/dev/stdin').toString().split('\n');
const k = Number(stdin[0].split(' ')[1]);
const data = stdin.slice(1).filter((el) => el !== '');
const l = 1004;

const solution = () => {
	let result = 0;
	const matrix = new Array(l).fill(0).map((el) => new Array(l).fill(0));

	for (const el of data) {
		const [x1, y1, x2, y2] = el.split(' ');

		matrix[x1][y1] += 1;
		matrix[x1][y2] -= 1;
		matrix[x2][y1] -= 1;
		matrix[x2][y2] += 1;
	}
	
	for (let i = 0; i < l; i++) {
		for (let j = 1; j < l; j++) {
			matrix[i][j] += matrix[i][j - 1];
		}
	}
	
	for (let i = 1; i < l; i++) {
		for (let j = 1; j < l; j++) {
			matrix[i][j] += matrix[i - 1][j];
		}
	}
	
	for (let i = 0; i < l; i++) {
		for (let j = 0; j < l; j++) {
			if (matrix[i][j] === k) {
				result += 1;
			}
		}
	}
	console.log(result);
}
solution();
