from typing import List
import logging

# Configure logging
logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')
logger = logging.getLogger(__name__)

class WordSearch:
    """
    Contains logic to find whether given exists in board or not
    """

    def __init__(self):
        self._VISITED_CELL_CHAR = '#'

    def exist(self, board: List[List[str]], word: str) -> bool:
        """
        Checks whether word exists in given board
        :param board: board where we have to find word
        :param word: to search
        :return: True if word exists else False
        """
        logger.debug(f"Searching word: {word} in board: {board}")
        for row in range(len(board)):
            for col in range(len(board[row])):
                # finding first character at first index in the board
                if board[row][col] == word[0]:
                    logger.debug(f"{word[0]} found in row:{row} and column:{col}")
                    if self._helper(board, word, 0, row, col):
                        return True
        return False

    def _helper(self, board: List[List[str]], word: str, word_index: int, row: int, col: int) -> bool:
        """
        recursive function that check every character of word following the rules
        :param board: board where we have to find word
        :param word: wor we are searching for
        :param word_index: index of the character in word we are searching for
        :param row: row of the cell we are looking for
        :param col: column of the cell we are looking for
        :return: True if word exists else False
        """
        if word_index == len(word):
            return True

        if row < 0 or col < 0 or row >= len(board) or col >= len(board[row]):
            return False

        found: bool = False
        # character doesn't match with the cell, so returning
        if board[row][col] != word[word_index]:
            return found

        temp: str = board[row][col]
        # mark cell as visited
        board[row][col] = self._VISITED_CELL_CHAR
        # exploring in all four directions
        found = (
            # checking in right side cell
                self._helper(board, word, word_index + 1, row, col + 1)
                #  checking above cell
                or self._helper(board, word, word_index + 1, row - 1, col)
                #  checking below cell
                or self._helper(board, word, word_index + 1, row + 1, col)
                # checking left side cell
                or self._helper(board, word, word_index + 1, row, col - 1))
        # unmark cell as not visited
        board[row][col] = temp
        return found



if __name__ == "__main__":
    board: List[List[str]] = [['A','B','C','E'],['S','F','C','S'], ['A','D','E','E']]
    word: str = 'ABCCED'
    logger.info(f"board: {board} word: {word} ----- result: {WordSearch().exist(board, word)}")
    word: str = 'SEE'
    logger.info(f"board: {board} word: {word} ----- result: {WordSearch().exist(board, word)}")
    word: str = 'ABCB'
    logger.info(f"board: {board} word: {word} ----- result: {WordSearch().exist(board, word)}")