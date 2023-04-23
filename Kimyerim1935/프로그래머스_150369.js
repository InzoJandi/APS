/*
 * Programers
 * https://school.programmers.co.kr/learn/courses/30/lessons/150369
 * Problem Number: 150369
 */


function solution(cap, n, deliveries, pickups) {
    let answer = 0;
    let delSum = deliveries.reduce((a,b)=>a+b,0);
    let pickSum = pickups.reduce((a,b)=>a+b,0);
//배달해야하는 화물, 수거해야할 화물 모두 0이되면 종료
    while(delSum !== 0 || pickSum !== 0){
        deleteZero(deliveries);
        deleteZero(pickups);
        let len = Math.max(deliveries.length, pickups.length);
        answer += len*2;
        delSum -= delItem(deliveries, cap);
        pickSum -= delItem(pickups, cap);
    }
    return answer;
}
//뒤에서 부터 0이 있으면 제거해줌
const deleteZero = (arr)=>{
    for(let i=arr.length-1; i>=0; i--){
        if(arr[i] === 0) arr.pop();
        else return;
    }
}
//현재 cap에 맞게, 뒤에서부터 빼줌
//ex) 0 3 2에 cap이 3이면 => 0 2 0
const delItem = (arr,cap) =>{
    let cnt = 0;
    for(let i=arr.length-1; i>=0; i--){
        if(arr[i] >= cap){
            arr[i] -= cap;
            cnt += cap;
            break;
        } 
        else{
            cap -= arr[i];
            cnt += arr[i];
            arr[i] = 0;
        } 
    }
    return cnt;
}
