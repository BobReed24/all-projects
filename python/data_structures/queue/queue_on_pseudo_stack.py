from typing import Any

class Queue:
    def __init__(self):
        self.stack = []
        self.length = 0

    def __str__(self):
        printed = "<" + str(self.stack)[1:-1] + ">"
        return printed

    def put(self, item: Any) -> None:
        self.stack.append(item)
        self.length = self.length + 1

    def get(self) -> Any:
        self.rotate(1)
        dequeued = self.stack[self.length - 1]
        self.stack = self.stack[:-1]
        self.rotate(self.length - 1)
        self.length = self.length - 1
        return dequeued

    def rotate(self, rotation: int) -> None:
        for _ in range(rotation):
            temp = self.stack[0]
            self.stack = self.stack[1:]
            self.put(temp)
            self.length = self.length - 1

    def front(self) -> Any:
        front = self.get()
        self.put(front)
        self.rotate(self.length - 1)
        return front

    def size(self) -> int:
        return self.length
