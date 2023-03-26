/*
 * Programers
 * https://school.programmers.co.kr/learn/courses/30/lessons/87391
 * Problem Number: 87391
 * Level: 3
 * Algorithm: 시뮬레이션
 */
        
 // 타겟 좌표에서 시작 하는 역순과정
 // queries를 역순으로 읽고 
 // 공의 이동방향 반대

class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {
      
        int x1 = x, y1 = y;
        int x2 = x, y2 = y;
        
        for(int i=queries.length-1; 0<=i; i--){
            
            if(queries[i][0]==2){
                if(x1!=0){ x1 = x1+queries[i][1]; }
                x2 = x2+queries[i][1] < n-1 ? x2+queries[i][1] : n-1;
                if(n<x1){ return 0; }
            }else if(queries[i][0]==3){
                x1 = 0 < x1-queries[i][1] ? x1-queries[i][1] : 0;
                if(x2!=n-1){ x2 = x2-queries[i][1]; }
                if(x2<0){ return 0; }
            }else if(queries[i][0]==0){
                if(y1!=0){ y1 = y1+queries[i][1]; }
                y2 = y2+queries[i][1] < m-1 ? y2+queries[i][1] : m-1;
                if(m<y1){ return 0; }
            }else{
                y1 = 0 < y1-queries[i][1] ? y1-queries[i][1] : 0;
                if(y2!=m-1){ y2 = y2-queries[i][1]; }
                if(y2<0){ return 0; }
            }
        }
        
        long X = x2-x1+1;
        long Y = y2-y1+1;
        
        return X*Y;
        
    }
}