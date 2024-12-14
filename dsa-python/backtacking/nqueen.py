from typing import List

class NQueen:
    """
    Contains logic to place queen in a board following all the conditions
    """
    def __init__(self):
        self._Q = 'Q'
        self._EMPTY = '.'

    def place(self, n: int):
        """
        Places queen to each cell following all the the conditions
        :param n: size of the board
        """
        board: List[List[str]] = self._initializeBoard(n)
        resultant: List[List[str]] = []
        self._helper(board, 0, resultant)
        print(resultant)


    def _initializeBoard(self, n) -> List[List[str]]:
        """
        Create board of the size passed and initialize it with default values
        :param n: size of the board
        :return: board when queen will be placed
        """
        return [[self._EMPTY for _ in range(n)] for _ in range(n)]

    def _helper(self, board, row, resultant):
        """
        recursive function that check whether in a particular cell queen can placed or not by following all the conditions
        :param board: where queen needs to be placed
        :param row: row in which we are looking the cell to place queen
        :param resultant: final result
        """
        if row == len(board):
            resultant.append([''.join(r) for r in board])
            return

        # iterating over each column of the row
        for col in range(len(board)):
            if self._is_safe(board, row, col):
                board[row][col] = self._Q
                self._helper(board, row+1, resultant)
                board[row][col] = self._EMPTY

    def _is_safe(self, board, row, col)  -> bool:
        """
        Checks whether queen can be placed on a particular cell. Conditions are
        1) No other queen should be there in row.
        2) No other queen should be there in column.
        3) No other queen should be there diagonally.

        :param board: where we have to check
        :param row: row of the cell
        :param col: column of the cell
        :return: True if queen can be place else False
        """
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



NQueen().place(4)