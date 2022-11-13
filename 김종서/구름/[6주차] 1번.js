const fs = require('fs');
const stdin = fs.readFileSync('/dev/stdin').toString().split('\n');

const solution = () => {
	stdin.forEach((el) => {
		let sum = 0;
		let mul = 1;
		
		for (let i = 0; i < el.length; i++) {
			if (i % 2 === 0) {
				sum += Number(el[i]);
			} else if (i % 2 === 1 && el[i] !== '0') {
				mul *= Number(el[i]);
			}
		}
		
		console.log((sum * mul) % 10);
	})
}
solution();
