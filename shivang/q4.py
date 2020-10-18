class Solution:
    def solution(self, matrix, target):
        m = len(matrix)
        if m == 0:
            return False
        n = len(matrix[0])
        if n == 0:
            return False
        y = m-1
        x = 0
        while x < n and y >= 0:
            if matrix[y][x] == target:
                return True
            elif matrix[y][x] < target:
                x += 1
            else:
                y -= 1
        return False

sol = Solution()

mat = [
    [1,   4,  7, 11, 15],
    [2,   5,  8, 12, 19],
    [3,   6,  9, 16, 22],
    [10, 13, 14, 17, 24],
    [18, 21, 23, 26, 30]
]

print(sol.solution(mat, 13))