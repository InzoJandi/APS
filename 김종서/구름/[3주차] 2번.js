const fs = require('fs');
const stdin = fs.readFileSync('/dev/stdin').toString().split('\n');
const data = stdin[1];

const obj = {
	1: '1.,?!',
	2: '2ABC',
	3: '3DEF',
	4: '4GHI',
	5: '5JKL',
	6: '6MNO',
	7: '7PQRS',
	8: '8TUV',
	9: '9WXYZ'
}

const solution = () => {
	let result = '';
	let cnt = 0;
	
	for (let i = 0; i < data.length; i++) {
		if (i === data.length) {
			break;
		}
		
		if (data[i] === data[i + 1]) {
			cnt++;
		} else {
			cnt++;
			result += obj[Number(data[i])][(cnt - 1) % obj[Number(data[i])].length];
			cnt = 0;
		}
	}
	console.log(result);
}
solution();
