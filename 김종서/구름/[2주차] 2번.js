// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });

	let result = 0;
	let stack = [];
	
	for await (const line of rl) {
 		const arr = rl._line_buffer.split('');
		
		arr.forEach((el) => {
			if (stack.length === 0) {
				stack.push(el);
				result++;
			} else if (stack[stack.length - 1] === el) {
				stack.push(el);
			} else {
				stack = [];
				stack.push(el);
				result++;
			}
		})
		
		// 아무 값도 없으면 stack에 넣고 +1
		// 같으면 stack에 넣고 +0
		// 다르면 stack을 비우고 stack에 넣고 +1
		
		console.log(result);
		
		rl.close();
	}
	
	process.exit();
})();
