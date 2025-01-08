from typing import List


class PhoneNumber:
    _digit_to_letter_dict = {
        '2': 'abc',
        '3': 'def',
        '4': 'ghi',
        '5': 'jkl',
        '6': 'mno',
        '7': 'pqrs',
        '8': 'tuv',
        '9': 'wxyz',
    }

    def letterCombination(self, digits: str) -> List[str]:
        if not digits:
            return []

        combinations: List[str] = []
        self._backtrack(digits, 0, [], combinations)
        return combinations

    def _backtrack(self, digits: str, index: int, current_combination: List[str], combinations: List[str]):
        """
        recursive function to find all the possible combinations
        :param digits: string whose combination we have to find
        :param index: index of the digit we are iterating on
        :param current_combination: ongoing combinations
        :param combinations: contains all the possible combinations
        """
        if index == len(digits):
            combinations.append(''.join(current_combination))
            return

        letters = self._digit_to_letter_dict[digits[index]]
        for letter in letters:
            current_combination.append(letter)
            self._backtrack(digits, index + 1, current_combination, combinations)
            current_combination.pop()


if __name__ == "__main__":
    print(PhoneNumber().letterCombination('23'))
