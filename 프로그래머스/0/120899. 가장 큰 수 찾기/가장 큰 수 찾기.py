def solution(array):
    max_value = max(array)
    return [max_value, array.index(max_value)]