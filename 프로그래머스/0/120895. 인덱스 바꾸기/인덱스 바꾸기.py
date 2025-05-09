def solution(my_string, num1, num2):
    my_string = list(my_string)  # 문자열 -> 리스트
    my_string[num1], my_string[num2] = my_string[num2], my_string[num1]  # 인덱스 문자 교환
    return ''.join(my_string)