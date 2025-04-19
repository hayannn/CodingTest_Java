# 알고리즘
# 0. 모음 사전 형태 이해
# A
# AA
# AAA
# AAAA
# AAAAA
# AAAAE
#...
# UUUUU
# 1. 알파벳 모음 사전 배열 선언, 단어 모음 words 배열 선언
# 2. DFS 함수
# 2-1. 길이가 5 초과면 탐색 중단 (문제 조건)
# 2-2. 빈 문자열은 제외하고 저장
# 2-3. # 각 모음을 하나씩 붙여서 재귀 호출
# 3. DFS 실행
# 3-1. 빈 문자열부터 시작 (모든 조합을 탐색)
# 4. 사전순 정렬(words)
# 5. 위치는 0부터 시작하므로 +1

def solution(word):
    alpha = ['A', 'E', 'I', 'O', 'U']
    words = []
    
    def dfs(curr):
        if len(curr) > 5:
            return
        if curr:
            words.append(curr)
        for ch in alpha:
            dfs(curr + ch)
    
    dfs("")
    words.sort()
    
    answer = words.index(word) + 1
    return answer