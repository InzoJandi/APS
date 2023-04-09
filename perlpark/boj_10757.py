"""
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10757
 * Level: Bronze V
 * Algorithm: Mathematics / Implementation / Arithmetic / Arbitrary Precision / Big Integers
"""

""" Pseudocode *
파이썬3는 큰 수를 위한 타입이 별도로 없으므로 input을 int 값으로만 변경하여 계산하면 됨
"""

import sys

a, b = sys.stdin.readline().split()
print(int(a) + int(b))