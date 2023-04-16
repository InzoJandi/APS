package main

import (
	"APS/steven/array"
	"APS/steven/dp"
	"APS/steven/graph"
	"APS/steven/greedy"
	"APS/steven/math"
	"APS/steven/simulation"
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
	dp.GenerateParenthesis(3)
	graph.FindJudge(3, [][]int{{1, 3}, {2, 3}})
	graph.FindCenter([][]int{{1, 2}, {2, 3}, {4, 2}})
	math.IsHappy(19)
	sort.SearchInsert([]int{1, 2, 5, 7}, 2)
	array.RemoveDuplicates([]int{0, 0, 1, 1, 1, 2, 2, 3, 3, 4})
	dp.CombinationSum([]int{2, 3, 6, 7}, 7)
	string.IsPalindrome("A man, a plan, a canal: Panama")
	array.Merge([]int{1, 2, 3, 0, 0, 0}, 3, []int{2, 5, 6}, 3)
	dp.Permute([]int{1, 2, 3})
	simulation.GenerateMatrix(3)
	array.SingleNumber([]int{1, 1, 2, 2, 3})
	string.CountAndSay(4)
}
