/*
 * LeetCode
 * https://leetcode.com/problems/merge-sorted-array/
 * Problem Number: 88
 * Level: Easy
 * Algorithm: Two Pointer
 */

/* Pseudocode *
 * i, j, k 세 개의 포인터 지정
 * i, j 두 개의 포인터 중 하나라도 0보다 작아진다면 반복문 종료
 * nums1에 저장해야 하기 때문에 k 포인터를 사용해 nums1에 sort된 값 저장. 
 * 저장될 때마다 사용한 포인터 -1
 * j pointer가 남아 있으면 nums1에 추가
 */



package array

import "fmt"

func Merge(nums1 []int, m int, nums2 []int, n int) {
	// 세 개의 포인터를 선언 & 할당
	// i는 nums1, j는 nums2, k는 sort된 nums1의 인덱스
	i, j, k := m-1, n-1, m+n-1

	// i, j 두 개의 포인터 중 하나라도 0보다 작아지면 반복문 종료
	// nums1에 저장해야 하기 때문에 k 포인터를 사용해 nums1에 sort된 값 저장
	// 저장될 때마다 사용한 포인터 -1,
	for i >= 0 && j >= 0 {
		// nums1의 값이 더크면 nums1의 값을 넣고 i - 1
		if nums1[i] >= nums2[j] {
			nums1[k] = nums1[i]
			i--
		// nums2의 값이 더크면 nums2의 값을 넣고 j - 1
		} else {
			nums1[k] = nums2[j]
			j--
		}
		// 모든 경우에 k - 1
		k--
	}

	// j pointer가 남아 있으면 nums1에 추가
	for j >= 0 {
		nums1[k] = nums2[j]
		j--
		k--
	}

	fmt.Println(nums1)
}
