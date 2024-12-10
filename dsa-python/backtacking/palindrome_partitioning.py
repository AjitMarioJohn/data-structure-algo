from typing import List
import logging

# Configure logging
logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')
logger = logging.getLogger(__name__)


class PalindromePartitioning:


    def partition(self, word: str) -> List[List[str]]:
        """
             Will found out all the partition of the word that are palindrome.

            word  String whose partitioning that are palindrome we have to see
        """
        resultant: List[List[str]] = []
        current_partition: List[str] = []

        logger.info(f"starting partitioning to find palindrome for word {word}")
        self._partitionHelper(word, current_partition, resultant, 0)

        return resultant

    def _partitionHelper(self, word, current_partition, resultant, start):
        """
        Using backtracking we are partitioning the word and finding whether the partition is palindrome or not.
        If not palindrome we are skipping else moving to another partition

        :param word: word whose palindrome partitioning we have to find
        :param current_partition: contains list of all the partition
        :param resultant: this is the final list which will contains all the palindrome partition
        :param start: index of the word from which we have to start
        :return:
        """
        if start == len(word):
            resultant.append(list(current_partition))
            return

        length: int = len(word)
        for end in range(start, length):
            if self.is_palindrome(word, start, end):
                word_substring = word[start: end + 1]
                logger.debug(f"adding { word_substring } to current partition")
                current_partition.append(word_substring)
                self._partitionHelper(word, current_partition, resultant, end + 1)
                current_partition.pop()

    def is_palindrome(self, word:str, start: int, end: int) -> bool:
        """
        Checks whether the given word is palindrome or not

        :param word: given string whose palindrome we have to check
        :param start: index of the word from which we have to check
        :param end:  end index of the word
        :return: bool
        """
        logger.debug(f"checking palindrome for string {word}")
        while start < end:
            if word[start] != word[end]:
                logger.debug(f"{word} is not a palindrome")
                return False
            start+=1
            end-=1

        logger.debug(f"{word} is a palindrome")
        return True

# Example usage
if __name__ == "__main__":
    print(PalindromePartitioning().partition("aab"))
    print(PalindromePartitioning().partition("aab"))