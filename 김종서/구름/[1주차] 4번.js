const fs = require('fs');
const stdin = fs.readFileSync('/dev/stdin').toString().split('\n');
const arr = stdin[1].split(' ');

function isPrime(n) {			
	if (n === 1) {
		return false;
	}
			
	for (let i = 2; i <= Math.sqrt(n); i++) {
		if (n % i === 0) {
			return false;
		}
	}
			
	return true;
}


const solution = () => {
	let result = 0;
	
	for (let i = 1; i <= arr.length; i++){
		if (isPrime(i)){
			result += Number(arr[i - 1]);
		}
	}
	
	console.log(result);
}

solution();
