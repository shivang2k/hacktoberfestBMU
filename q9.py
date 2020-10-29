class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def solution(root) -> int:
    count = []
    x = 0
    def preOrder(root, x):
        if root:
            x += 1
            preOrder(root.left, x)
            preOrder(root.right, x)
        else:
            count.append(x)
            x = 0
    preOrder(root, 0)
    return max(count)


root = TreeNode(10)
root.left = TreeNode(9)
root.right = TreeNode(11)
root.left.left = TreeNode(6)
root.left.right = TreeNode(5)
root.left.right.left = TreeNode(7)
root.right = TreeNode(11)

print(solution(root))