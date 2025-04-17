def solution(n):
    answer = []
    for i in range(1, n+1):
        if i % 2 != 0: # 홀수인 경우
            answer.append(i)
    return answer