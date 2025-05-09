def solution(rsp):
    win_map = {'0': '5', '2': '0', '5': '2'}
    return ''.join(win_map[move] for move in rsp)