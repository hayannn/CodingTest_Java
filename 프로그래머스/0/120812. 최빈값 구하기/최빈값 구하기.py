def solution(array):
    index = [0] * 1001
    
    for i in array:
        index[i] += 1
    
    max_freq = max(index) # 제일 큰 빈도수
    
    if index.count(max_freq) > 1: #최빈값이 2개 이상인지 확인
        return -1
    return index.index(max_freq)