// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
	for await (const line of rl) {
		const arr = rl._line_buffer.split(' ');
		
		const x = Math.abs(arr[3] - arr[0]);
		const y = Math.abs(arr[2] - arr[1]);

		console.log(x + y);		
		rl.close();
	}
	
	process.exit();
})();
