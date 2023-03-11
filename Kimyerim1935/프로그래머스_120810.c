/*
 * Programers
 * https://school.programmers.co.kr/learn/courses/30/lessons/120808?language=c
 * Problem Number: 120808
 * Level: 0
 * Algorithm: 코딩테스트 연습
 */

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int* solution(int numer1, int denom1, int numer2, int denom2) {
    int* answer = (int*)malloc(1);
    
    int a = denum1 * num2 + denum2 * num1;
    int b = num1 + num2;
    int c = 1;
    
    for(int i =1; i <= a; i++) {
        if (a%i == 0 && b%i == 0) {
            c = i;
        }
    }
    
    answer[0]= a/c;
    answer[1]=b/c;
    
    return answer;
}