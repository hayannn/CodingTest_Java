def solution(num, k):
    num_str = str(num)
    return num_str.find(str(k)) + 1 if str(k) in num_str else -1