"""
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11021
 * Level: Bronze V
 * Algorithm: Mathematics / Implementation / Arithmetic
"""

""" Pseudocode *
enumerate를 이용하여 인덱스 값을 사용할 수 있는 반복문을 돌림
Case #문자와 인덱스, numbers에서 split 하여 얻은 a, b 값을 더하여 형식에 맞게 출력
"""

import sys

T = int(sys.stdin.readline())
numbers = [sys.stdin.readline().strip() for _ in range(T)]

for i, num in enumerate(numbers, start = 1):
    a, b = num.split()
    print("Case #", i, ": ", int(a) + int(b), sep = "")