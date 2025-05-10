from collections import Counter

def solution(s):
    cnt = Counter(s)
    unique_chars = [ch for ch in s if cnt[ch] == 1]
    return ''.join(sorted(unique_chars))