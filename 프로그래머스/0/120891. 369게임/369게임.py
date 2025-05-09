def solution(order):
    return sum(map(lambda x: str(order).count(str(x)), [3, 6, 9]))