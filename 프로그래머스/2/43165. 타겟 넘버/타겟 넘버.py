# 알고리즘
# 1. 각 숫자 앞에 연산자를 붙이는 경우의 수 : 2가지(+, -) -> 전체 경우의 수는 2^n
# 2. dfs(index, total) : index번째 수까지 고려했을 때, 누적합이 total인 경우 탐색
# 3. 마지막까지 탐색했을 때 누적합이 target이면 카운팅

def solution(numbers, target):
    answer = [0]
    
    def dfs(index, total):
        if index == len(numbers):
            if total == target:
                answer[0] += 1
            return
        # 2가지 경우의 수
        dfs(index+1, total + numbers[index])
        dfs(index+1, total - numbers[index])

    dfs(0, 0)
    
    return answer[0]