// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
	for await (const line of rl) {
		let result = 1;
		
		const arr = rl._line_buffer.split(' ');
	
		for (const el of arr) {
			result *= el;
		}
		
		rl.close();
		console.log(BigInt(result).toString());
	}
	process.exit();
})();
