function solution(citations) {
    let result = 0;
    
    for (let i = 1; i < citations.length + 1; i++) {
        const h = citations.filter((el) => el >= i).length;

        if (h >= i) {
            result = i;
        }
    }
    return result;
}
