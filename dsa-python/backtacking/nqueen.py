from typing import List

class NQueen:
    def __init__(self):
        self._Q = 'Q'
        self._EMPTY = '.'

    def solve(self, n: int):
        board: List[List[str]] = self._initializeBoard(n)
        resultant: List[List[str]] = []
        self._helper(board, 0, resultant)
        print(resultant)


    def _initializeBoard(self, n) -> List[List[str]]:
        return [[self._EMPTY for _ in range(n)] for _ in range(n)]

    def _helper(self, board, row, resultant):
        if row == len(board):
            resultant.append([''.join(r) for r in board])
            return

        for col in range(len(board)):
            if self.is_safe(board, row, col):
                board[row][col] = self._Q
                self._helper(board, row+1, resultant)
                board[row][col] = self._EMPTY

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



NQueen().solve(4)