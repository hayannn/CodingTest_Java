# 총 n명이니까 -> n조각 필요
# 한 판에 slice 조각이 있으니까 -> n / slice 판이 필요함
# 나눗셈 결과 올림 처리

def solution(slice, n):
    return (n + slice - 1) // slice