class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.lis = []
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.lis.append(x)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        return self.lis.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        return self.lis[0]
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return len(self.lis) == 0


q = MyQueue()

q.push(1)
q.push(2)

print(q.pop())

print(q.peek())

print(q.empty())
