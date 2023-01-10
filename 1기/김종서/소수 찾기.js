// 문제
// 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

// 입력
// 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.

// 출력
// 주어진 수들 중 소수의 개수를 출력한다.

function solution(arr) {
    // result을 선언해 소수이면 +1을 할당할 수 있도록 한다.
    let result = 0;
    
    // 반복문으로 arr의 내부의 값을 검증한다.
    for (let num of arr) {
        if (isPrime(num)) {
            result++;
        }
    }

    // 소수는 1과 자기 자신만으로 나누어지는 수를 말한다. 이를 검증하는 함수를 생성한다.
    function isPrime(n) {
        if (n === 1) {
            return false;
        }

        if (n === 2) {
            return true;
        }

        // 제곱근 보다 작은 수에서 나눠지는 수가 나오지 않는다면, 제곱근 보다 큰 수에서도 나눠지는 수가 나올 수 없다.
        for (let i = 2; i < Math.sqrt(n); i++) {
            if (n % i === 0) {
                return false;
            }
        }
        return true;
    }

    return result;
}
