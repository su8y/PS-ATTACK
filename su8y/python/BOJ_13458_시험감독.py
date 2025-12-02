class BOJ_13458_시험감독:
    def __init__(self):
        return

    def solution(self, n: int, rooms: list, B: int, C: int):
        teachers = 0
        for person in rooms:
            if person == 0: continue
            # 총 시험 감독관
            person -= B
            teachers += 1
            if person > 0:
                if person % C > 0:
                    teachers += person // C + 1
                else:
                    teachers += person // C
        return teachers
