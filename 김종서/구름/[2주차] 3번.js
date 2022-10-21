// Run by Node.js
const fs = require('fs');
const stdin = fs.readFileSync('/dev/stdin').toString().split('\n');

const pick = stdin.shift().split(' ')[1] - 1;
const arr = [];

const solution = () => {
	for (const el of stdin) {
		const data = el.split(' ');
		arr.push([data[0], data[1]]);
	}

	arr.sort((a, b) => {
    if (b[0] > a[0]) return -1;
    else if (a[0] > b[0]) return 1;
    else return 0;
  });
	
	for (let i = 1; i < arr.length; i++) {
		if (arr[i - 1][0] === arr[i][0]) {
			arr.sort((a, b) => {
				if (b[1] > a[1]) return -1;
				else if (a[1] > b[1]) return 1;
				else return 0;
			})
		}
	}
	
	console.log(`${arr[pick][0]} ${arr[pick][1]}`);
}

solution();
