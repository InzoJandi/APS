package string

import (
	"fmt"
	"strings"
)

func LengthOfLastWord(s string) int {
	// 공백을 제거한 배열 생성
	arr := strings.Fields(s)
	// 배열 마지막 단어 추출
	lastWord := arr[len(arr)-1]
	fmt.Println(len(lastWord))
	return len(lastWord)
}
