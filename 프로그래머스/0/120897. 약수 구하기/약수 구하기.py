import math

def solution(n):
    divisors = []
    for p in range(1, int(math.sqrt(n)) + 1):
        if n % p == 0:
            divisors.append(p)
            if p != n // p:
                divisors.append(n // p)
    return sorted(divisors)