import math

def solution(numer1, denom1, numer2, denom2):
    x = numer1 * denom2 + numer2 * denom1
    y = denom1 * denom2

    g = math.gcd(x, y)
    answer = [x//math.gcd(x, y), y//math.gcd(x, y)]
    return answer