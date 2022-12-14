// 문제: 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
// 입력: 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
// 출력: 주어진 수들 중 소수의 개수를 출력한다.
// 에라토스테네스의 체 참고 https://ko.wikipedia.org/wiki/%EC%86%8C%EC%88%98_(%EC%88%98%EB%A1%A0)

const isPrime = (n) => {
    // 1은 소수가 아니다.
    if (n == 1) {
        return false;
    }

    // 2부터 시작하여, 2의 배수 즉, 나머지가 0인 짝수는 제외한다.
    // 수가 수를 나누기 위해서는 그 몫이 항상 필요하며 나누는 수와 몫 중 어느 하나는 반드시 제곱근보다 작다.

    for (let i = 2; i <= Math.sqrt(n); i++) {
        if (n % i === 0) {
            return false;
        }
    }
    return true;
};

const input = require("fs").readFileSync("/dev/stdin").toString().trim();

const [v, nums] = input.split("\n");

console.log(nums.split(" ").filter((item) => isPrime(item)).length);
