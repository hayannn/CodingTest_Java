# 알고리즘
# participant 배열과 completion 배열을 비교해서 -> 일치하지 않는 경우만 출력하도록 구성
# 1. participant 배열 정렬
# 2. completion 배열 정렬
# 3. 일치하지 않는 경우 -> return

def solution(participant, completion):
    participant.sort()
    completion.sort()
    for p, c in zip(participant, completion):
        if p != c:
            return p
    return participant[-1]
        