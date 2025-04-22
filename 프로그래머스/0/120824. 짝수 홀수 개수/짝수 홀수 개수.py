def solution(num_list):
    count_x = 0
    count_y = 0
    
    for x in num_list:
        if x % 2 == 0:
            count_x += 1
        else:
            count_y += 1
    
    return [count_x, count_y]