/*
 * LeetCode
 * https://leetcode.com
 * Problem Number: 22
 * Level: Medium
 * Algorithm: Dynamic Programming
 */

/* Pseudocode *

Base case는 open과 close 모두 n과 일치할 경우 s값을 result 배열에 추가한 뒤 종료
Recursive case는 open을 +1하는 경우와 close를 +1하는 경우로 나눠서 작성
그 결과를 살펴보면 아래와 같음.

open generate - open:  0 / close:  0
open generate - open:  1 / close:  0
open generate - open:  2 / close:  0
close generate - open:  3 / close:  0
close generate - open:  3 / close:  1
close generate - open:  3 / close:  2
close generate - open:  2 / close:  0
open generate - open:  2 / close:  1
close generate - open:  3 / close:  1
close generate - open:  3 / close:  2
close generate - open:  2 / close:  1
open generate - open:  2 / close:  2
close generate - open:  3 / close:  2
close generate - open:  1 / close:  0
open generate - open:  1 / close:  1
open generate - open:  2 / close:  1
close generate - open:  3 / close:  1
close generate - open:  3 / close:  2
close generate - open:  2 / close:  1
open generate - open:  2 / close:  2
close generate - open:  3 / close:  2
*/

package dp

import "fmt"

func GenerateParenthesis(n int) []string {
	var result []string
	generate(&result, "", 0, 0, n)
	fmt.Println(result)
	return result
}

func generate(result *[]string, s string, open int, close int, n int) {
	// Base Case
	if open == n && close == n {
		*result = append(*result, s)
		return
	}

	// Recursive Case - open + 1
	if open < n {
		fmt.Println("open generate -", "open: ", open, "/", "close: ", close)
		generate(result, s+"(", open+1, close, n)
	}


	// Recursive Case - close + 1
	if close < open {
		fmt.Println("close generate -", "open: ", open, "/", "close: ", close)
		generate(result, s+")", open, close+1, n)
	}
}
