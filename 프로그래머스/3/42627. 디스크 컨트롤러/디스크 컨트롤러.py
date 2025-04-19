# 알고리즘
# 0. s : 요청 시간, l : 작업 소요 시간, i번 작업
# 1. jobs 리스트 오름차순 정렬하기(요청 시간 기준)
# 2. 힙(우선순위 큐) 사용
# 2-1. (소요시간, 요청 시간)으로 최소힙에 저장 : heapq 이용
# 2-2. 현재 시간(time)을 기준으로 요청 시간 <= 현재 시간인 작업을 힙에 넣기
# 3. 총 걸린 시간을 모두 더해, 작업 개수로 나누기(정수 나누기 '//' 사용)


import heapq

def solution(jobs):
    jobs.sort()
    heap = []
    time, i, total = 0, 0, 0
    count = len(jobs)

    while i < count or heap:
        while i < count and jobs[i][0] <= time:
            heapq.heappush(heap, (jobs[i][1], jobs[i][0]))
            i += 1
            
        if heap:
            dur, req = heapq.heappop(heap)
            time += dur
            total += time - req
        else:
            time = jobs[i][0]
    return total // count