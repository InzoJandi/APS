package main

import (
	"APS/steven/greedy"
	"APS/steven/math"
	"APS/steven/sort"
	"APS/steven/stack"
	"APS/steven/string"
)

func main() {
	string.LengthOfLastWord("hello world")
	greedy.MaxArea([]int{1, 8, 6, 2, 5, 4, 8, 3, 7})
	greedy.MaxProfit([]int{7, 1, 5, 3, 6, 4})
	math.IsPalindrome(121)
	sort.Solution(10, 2)
	math.Reverse(1534236469)
	stack.IsValid("([])]")
}
