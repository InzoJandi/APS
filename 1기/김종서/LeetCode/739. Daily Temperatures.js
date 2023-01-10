/**
 * @param {number[]} temperatures
 * @return {number[]}
 */
var dailyTemperatures = function(temperatures) {
    const n = temperatures.length;
    const answer = new Array(n).fill(0);

    const stack = [];
    for (let j = 0; j < n; j++) {
        let cur = temperatures[j];
        while(stack.length > 0 && cur > stack[stack.length - 1][0]) {
            let arr = stack.pop();
            let idx = arr[1];
            answer[idx] = Math.abs(j - idx);
        }
        stack.push([cur, j])
    }
    return answer;
};
