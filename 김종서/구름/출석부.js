const fs = require('fs');
const stdin = fs.readFileSync('/dev/stdin').toString().split('\n');
const n = stdin[0].split(' ')[0];
const k = stdin[0].split(' ')[1];
const data = stdin.slice(1).map((el) => el.split(' '));

const solution = () => {
	const sorted = data.sort((a, b) => {
  	if (a[0] > b[0]) return 1;
    else if (b[0] > a[0]) return -1;
    else return 0;
	});
	
	sorted.sort((a, b) => {
		if (a[0] === b[0]) {
			return a[1] - b[1];
		}
	})
	console.log(sorted[k - 1].join(' '));
}
solution();
