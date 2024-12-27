from typing import List


class Sudoku:
    """
    Contains logic to solve the sudoku puzzle
    """

    def __init__(self):
        self._DEFAULT_EMPTY_COLUMN_CHAR: str = '.'

    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Solve the puzzle considering all the rules
        :param board: puzzle which we have to solve
        """
        self._helper(board)

    def _helper(self, puzzle: List[List[str]]) -> bool:
        """
        Recursive helper function to solve the puzzle
        :param puzzle: puzzle which we have to solve
        """
        for row in range(len(puzzle)):
            for column in range(len(puzzle[row])):
                # Check whether the cell is empty or not. If empty, then only proceed
                if puzzle[row][column] != self._DEFAULT_EMPTY_COLUMN_CHAR:
                    continue

                for num in range(1, 10):
                    char_num = str(num)
                    if self._can_insert(char_num, row, column, puzzle):
                        puzzle[row][column] = char_num
                        if self._helper(puzzle):
                            return True
                        else:
                            puzzle[row][column] = self._DEFAULT_EMPTY_COLUMN_CHAR
                # Return false as no number can be inserted in the cell
                return False
        # Code will come here when we are trying to solve an already solved puzzle
        return True

    def _can_insert(self, num: str, row: int, column: int, puzzle: List[List[str]]) -> bool:
        """
        Check if all the required conditions are met to insert the particular number in the cell.
        Conditions are listed below:

        1) Number should be unique in row.
        2) Number should be unique in column.
        3) Number should be unique in the quadrant where the cell resides.

        :param num: The number we want to insert in the cell
        :param row: The row of the cell
        :param column: The column of the cell
        :param puzzle: The puzzle to solve
        :return: True if all conditions are met to insert the number, else False
        """
        # Determine the starting row and column of the quadrant where the cell resides
        quadrant_row_start: int = 3 * (row // 3)
        quadrant_column_start: int = 3 * (column // 3)

        for index in range(9):
            quadrant_row: int = quadrant_row_start + (index // 3)
            quadrant_col: int = quadrant_column_start + (index % 3)
            if (puzzle[row][index] == num or
                    puzzle[index][column] == num or
                    puzzle[quadrant_row][quadrant_col] == num):
                return False

        return True


# Test the Sudoku solver
if __name__ == "__main__":
    # puzzle = [
    #     ['5', '3', '.', '.', '7', '.', '.', '.', '.'],
    #     ['6', '.', '.', '1', '9', '5', '.', '.', '.'],
    #     ['.', '9', '8', '.', '.', '.', '.', '6', '.'],
    #     ['8', '.', '.', '.', '6', '.', '.', '.', '3'],
    #     ['4', '.', '.', '8', '.', '3', '.', '.', '1'],
    #     ['7', '.', '.', '.', '2', '.', '.', '.', '6'],
    #     ['.', '6', '.', '.', '.', '.', '2', '8', '.'],
    #     ['.', '.', '.', '4', '1', '9', '.', '.', '5'],
    #     ['.', '.', '.', '.', '8', '.', '.', '7', '9']
    # ]

    puzzle = [[".", ".", ".", ".", ".", ".", ".", ".", "."], [".", "9", ".", ".", "1", ".", ".", "3", "."],
     [".", ".", "6", ".", "2", ".", "7", ".", "."], [".", ".", ".", "3", ".", "4", ".", ".", "."],
     ["2", "1", ".", ".", ".", ".", ".", "9", "8"], [".", ".", ".", ".", ".", ".", ".", ".", "."],
     [".", ".", "2", "5", ".", "6", "4", ".", "."], [".", "8", ".", ".", ".", ".", ".", "1", "."],
     [".", ".", ".", ".", ".", ".", ".", ".", "."]]
    sudoku = Sudoku()
    sudoku.solveSudoku(puzzle)
    for row in puzzle:
        print(row)
