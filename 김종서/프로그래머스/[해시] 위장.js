function solution(clothes) {
    let result = 1;
    let obj = {};
    
    clothes.forEach((el) => {
        if (!obj[el[1]]) {
            obj[el[1]] = 1;
        } else {
            obj[el[1]] += 1;
        }
    })
    
    for(let i of Object.keys(obj)) {        
        result *= obj[i] + 1;    
    }    
    return result - 1;
}
