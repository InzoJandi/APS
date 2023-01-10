const fs = require('fs');
const stdin = fs.readFileSync('/dev/stdin').toString().split('\n');

let cur = Number(stdin[0].split(' ')[0]);
const data = stdin.slice(1).filter((el) => el !== '').map((el) => el.split(' ')).map((el) => [el[0], Number(el[1])]);

const solution = () => {
	const reservation = [];
	
  for (const el of data) {
		if (el[0] === 'deposit') {
			cur += el[1];
		} else if (el[0] === 'pay') {
			if (cur >= el[1]) {
				cur -= el[1];
			}
		} else if (el[0] === 'reservation') {
			if (reservation.length === 0 && cur >= el[1]) {
				cur -= el[1];
			} else {
				reservation.push(el[1]);
			}
		}
		
		while (reservation.length > 0 && cur >= reservation[0]) {
			cur -= reservation[0];
			reservation.shift();
		}
	}
	
	console.log(cur);
}

solution();
