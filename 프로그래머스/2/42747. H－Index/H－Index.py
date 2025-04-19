# 알고리즘
# 문제. 논문 n편 중, h번 이상 인용된 논문이 h편 이상 and 나머지 논문이 h번 이하 인용 -> h 최댓값이 H-Index
# 첫번째 풀이
# 1. 배열 원소 개수 세기(len)
# 2. 배열 원소 합 // 배열 원소 개수로 return 값 구하기
#
# 두번째 풀이
# 1. 배열 정렬(내림차순 : 배열.sort(reverse=True))
# 2. 논문 순위와 해당 논문 인용 수를 비교해 -> 순위 번호가 인용 수와 같거나 작아지는 지점을 찾으면 됨

def solution(citations):
    citations.sort(reverse=True)  # 1. 내림차순 정렬

    for i in range(len(citations)):
        if i + 1 > citations[i]:  # 2. 순위 번호가 인용 수보다 커지면
            return i              # 그 직전까지가 H-Index
    return len(citations)         # 모든 논문이 i+1 <= 인용 수를 만족하면