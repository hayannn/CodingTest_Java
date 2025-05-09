def solution(my_string):
    digits = [int(c) for c in my_string if c.isdigit()]
    return sum(digits)