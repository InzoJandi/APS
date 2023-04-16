const SALES_LIST = [10, 20, 30, 40];

/* Pseudocode *
    1. 이모티콘 m개의 할인율 배율 구하기
    2. 이모티콘 구매 비용의 합, 이모티콘 플러스 서비스 가입자 수 구하기
*/

function solution(users, emoticons) {
    // [이모티콘 플러스 서비스 가입 수, 이모티콘 매출액]
    const answer = [0, 0];

    const discountsList = []; // 할인율 배열
    const arr = []; // 임시 배열

    // 이모티콘 m개의 할인율 배율
    /*
        [
            [ 10, 10 ], [ 10, 20 ],
            [ 10, 30 ], [ 10, 40 ],
            [ 20, 10 ], [ 20, 20 ],
            [ 20, 30 ], [ 20, 40 ],
            [ 30, 10 ], [ 30, 20 ],
            [ 30, 30 ], [ 30, 40 ],
            [ 40, 10 ], [ 40, 20 ],
            [ 40, 30 ], [ 40, 40 ]
        ]
    */

    function dfs(count) {
        // 모든 이모티콘 할인율을 구했다면
        if (count === emoticons.length) {
            discountsList.push(arr.slice(0));
            return;
        }

        SALES_LIST.forEach((sale) => {
            arr[count] = sale;
            dfs(count + 1);
        });
    }

    dfs(0);

    // 이모티콘 구매 비용의 합, 이모티콘 플러스 서비스 가입자 수 구하기
    function calculate(curDiscount) {
        let totalRegister = 0;
        let totalPrice = 0;

        // 사용자 수 만큼 반복
        users.forEach((curUser) => {
            // 사용자의 [비율, 가격]
            const [rate, maxPrice] = curUser;
            // 이모티콘 구매 비용의 합 구하기
            const price = emoticons.reduce((prev, emoticon, idx) => {
                // 자신의 기준에 따라 일정 비율 이상 할인하는 이모티콘을 모두 구매
                if (curDiscount[idx] >= rate) {
                    prev += (emoticon * (100 - curDiscount[idx])) / 100;
                }
                return prev;
            }, 0);

            // 이모티콘 구매 비용의 합이 일정 가격 이상이 된다면, 이모티콘 구매를 취소하고
            // 이모티콘 플러스 서비스에 가입
            if (price >= maxPrice) {
                totalRegister++;
            } else {
                totalPrice += price;
            }
        });

        return { totalRegister, totalPrice };
    }

    // 할인율 배열 순회
    discountsList.forEach((curDiscount, index) => {
        // 이모티콘 플러스 서비스 가입자, 이모티콘 판매액
        const { totalRegister, totalPrice } = calculate(curDiscount);
        if (totalRegister > answer[0]) {
            answer[0] = totalRegister;
            answer[1] = totalPrice;
        } else if (answer[0] === totalRegister && totalPrice > answer[1]) {
            answer[1] = totalPrice;
        }
    });

    return answer;
}
