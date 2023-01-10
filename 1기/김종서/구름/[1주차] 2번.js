// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	let data = [];
	
	for await (const line of rl) {
		data.push(line);
	}
	let result = 0;
	
	const first = data[0].split(' ')[1];

	for (let i = 1; i < data.length; i++) {
		if (data[i].includes(first)) {
			result++;
		}
	}
	
	console.log(result);
	rl.close();
	
	process.exit();
})();
