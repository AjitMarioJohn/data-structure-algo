from typing import List

class NQueenII:
    def __init__(self):
        self._Q = 'Q'
        self._EMPTY = '.'

    def solve(self, n: int):
        board: List[List[str]] = self._initializeBoard(n)
        print(self._helper(board, 0))


    def _initializeBoard(self, n) -> List[List[str]]:
        return [[self._EMPTY for _ in range(n)] for _ in range(n)]

    def _helper(self, board, row) -> int:
        if row == len(board):
            return 1

        count: int = 0
        for col in range(len(board)):
            if self.is_safe(board, row, col):
                board[row][col] = self._Q
                count+=self._helper(board, row+1)
                board[row][col] = self._EMPTY

        return count

    def is_safe(self, board, row, col)  -> bool:
        # iterating horizontally
        for index_row in range(row):
            if board[index_row][col] == self._Q:
                return False


        # iterating diagonally left
        row_index: int = row
        col_left: int = col

        while row_index >= 0 and col_left >= 0:
            if board[row_index][col_left] == self._Q:
                return False

            row_index-=1
            col_left-=1

        # iterating diagonally right
        row_index: int = row
        col_right: int = col
        while row_index > 0 and col_right < len(board):
            if board[row_index][col_right] == self._Q:
                return False

            row_index -= 1
            col_right += 1

        return True



NQueenII().solve(4)