function solution(genres, plays) {
    const result = [];
    
    // 객체 형태로 각 장르 당 재생 횟수를 더하기
    const objGenres = {};
    
    for (let i = 0; i < genres.length; i++) {
        if (!objGenres[genres[i]]) {
            objGenres[genres[i]] = plays[i]; 
        } else {
            objGenres[genres[i]] += plays[i];
        }
    }
    
    const arrGenres = [];

    // 장르 재생 횟수를 비교해 큰 순서대로 정렬
    for (const genre in objGenres) {
      arrGenres.push([genre, objGenres[genre]]);
    }

    arrGenres.sort((a, b) => {
      return b[1] - a[1];
    });
    
    // 상위 재생 장르부터 가장 많이 재생된 2개 곡 선정해서 삽입
    for (let i = 0; i < arrGenres.length; i++) {
        const arr = [];
        for (let j = 0; j < genres.length; j++) {
            if (genres[j] === arrGenres[i][0]) {
                arr.push([j, plays[j]]);
            }
        }
        arr.sort((a, b) => {
            return b[1] - a[1];
        })
                
        result.push(arr[0][0]);
        
        if (arr.length > 1) {
            result.push(arr[1][0]);   
        }
    }
    return result;
}
