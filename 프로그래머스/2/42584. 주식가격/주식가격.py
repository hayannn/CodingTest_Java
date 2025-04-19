# 알고리즘
# 1. 이중 for문 : answer 배열의 i번째와 j번째를 비교
# 2. price(i) > price(j)이면 가격이 떨어진 것이므로 정지

def solution(prices):
    answer = [0] * len(prices)
    for i in range(len(prices)):
        for j in range(i + 1, len(prices)):
            answer[i] += 1
            if prices[i] > prices[j]:
                break
    return answer