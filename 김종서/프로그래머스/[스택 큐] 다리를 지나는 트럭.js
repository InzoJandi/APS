function solution(bridge_length, weight, truck_weights) {
    let cnt = 0;
    let arr = new Array(bridge_length - 1).fill(0);
    
    while (truck_weights.length !== 0) {
        let n = truck_weights[0];
        let sumArr = arr.reduce((cur, acc) => cur + acc, 0);
        
        if (n + sumArr <= weight) {
            arr.shift();
            arr.push(truck_weights.shift());
        } else {
            arr.shift();
            arr.push(0)
        }
        cnt++
    }
    return cnt + bridge_length;
}
