from collections import deque

def solution(numbers, direction):
    numbers = deque(numbers)
    numbers.rotate(1 if direction == 'right' else -1)
    return list(numbers)