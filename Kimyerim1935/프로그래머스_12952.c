/*
 * Programers
 * https://school.programmers.co.kr/learn/courses/30/lessons/12952
 * Problem Number: 12952
 * Level: ?
 * Algorithm: 백트래킹
 */


#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include<string.h>
 
int queen_map[12][12];
int map_cnt = 0;
 
int isitokay(int i, int j, int n){
 
    for(int y = 0; y < j; y++){
        if(queen_map[i][y] == 1){
            return 0;
        }
    }
    
    for(int a = 0; a < j; a++){
        for (int b = 0; b < n; b++){
            if(abs(a-j) == abs(b-i) && queen_map[b][a] == 1){
                return 0;
            }
        }
    }
    
    for(int x = 0; x < i; x++){
        if(queen_map[x][j] == 1){
            return 0;
        }
    }
    return 1;
}
 
int make_queen(int sero, int n){   
    for(int i = 0; i < n; i++){
        if(isitokay(i, sero, n) == 1){
            queen_map[i][sero] = 1;
            if(sero == (n-1)){
                map_cnt++;
            }
            
            else{
                make_queen(sero+1, n);
            }
            queen_map[i][sero] = 0;
        }
    }
    return map_cnt;
}
 
int solution(int n) {
    int answer = 0;
    memset(queen_map, 0, sizeof(int)*n*n);
 
    answer = make_queen(0, n);
    
    return answer;
}