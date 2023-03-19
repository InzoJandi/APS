/*
 * Programers
 * https://school.programmers.co.kr/learn/courses/30/lessons/120826?language=c
 * Problem Number: 120826
 * Level: 0
 * Algorithm: 문자 제거하기
 */

/*
* 주어지는 letter를 my_string 문자열에서 제거한 뒤 리턴 
*/

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char* solution(const char* my_string, const char* letter) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int length = strlen(my_string);
    int j = 0;
    char* answer = (char*)malloc(length-1);
    
    for (int i = 0; i < length; i++) {
        if(my_string[i] != letter[0])
            answer[j++] = my_string[i];
    }
    
    answer[j] = NULL;
    return answer;
}