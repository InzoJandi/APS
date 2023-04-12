/*
 * Programers
 * https://school.programmers.co.kr/learn/courses/30/lessons/92341
 * Problem Number: 92341
 * Level: 2
 * Algorithm: Implementation
 */

function solution(fees, records) {
    const [basicTime, basicFee, min, fee] = fees;
    const cars = {};
    const candidate = {};
  
    const lastCar = [];

    const remainingCar = [];

    
    for (let x of records) {
        let [clock, car, history] = x.split(" ");
        let [hour, min] = clock.split(":").map(Number);
        
        if (history === "IN") {
            if (!lastCar.includes(car)) {
                candidate[car] = [hour, min, 0];
                remainingCar.push(car);
                continue;
            }
            candidate[car] = [hour, min, cars[car]];
            remainingCar.push(car);
        }
        
        if (history === "OUT") {
            lastCar.push(car);
            remainingCar.splice(remainingCar.indexOf(car), 1);
            let lastIn = candidate[car];
            let time = (hour - lastIn[0]) * 60 + min - lastIn[1];
            
            if (cars.hasOwnProperty(car)) {
                cars[car] = cars[car] + time;
            } else {
                cars[car] = time;
            }
        }
    };
    
    for (let car of remainingCar) {
        let lastIn = candidate[car];
        let time = (23 - lastIn[0]) * 60 + 59 - lastIn[1];
        if (cars.hasOwnProperty(car)) {
                cars[car] = cars[car] + time;
        } else {
            cars[car] = time;
        }
    }
    const answer = [];
    
    for (let [car, time] of Object.entries(cars)) {
        let lastIn = candidate[car];
        basicTime >= time ? time = basicFee : time = basicFee + Math.ceil((time - basicTime) / min) * fee;
        answer.push([car, time]);
    }
    
    return answer.sort((a, b) => a[0] - b[0]).map(v => v[1]);
}