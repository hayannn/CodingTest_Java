def solution(n, k):
    if n >= 10:
        return 12000 * n + (k - n // 10) * 2000 # 10개 이상이면 -> n을 10으로 나눈 몫을 음료 개수로 뺴서 가격에 곱해주면 됨
    else:
        return 12000 * n + 2000 * k