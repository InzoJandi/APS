// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
	const data = [];
	
	for await (const line of rl) {
		data.push(line);
	}
	
	for (let i = 0; i < data[0]; i++) { 
		const n = 2 * (i + 1);
		
		const testScores = data[n].split(' ').filter((el) => el !== '').map((el) => Number(el));
	
		let testSum = 0;
	
		for (const score of testScores) {
			testSum += score;
		}

		const testAverage = testSum / testScores.length;

		let testStudentOverAve = 0;

		for (const score of testScores) {
			if (score >= testAverage) {
				testStudentOverAve++;
			}
		}
		
		console.log(`${testStudentOverAve}/${testScores.length}`);
	}
	
	process.exit();
})();
