# Multiples of 3 and 5 below 1000
# Venkata Gogineni
# Unitest for the code included
import unittest


def sum_of_multiples_of_3_and_5(number1, number2):
    sum = 0
    for i in range(number1, number2):
        if (i % 3 == 0 or i % 5 == 0):
            sum += i
    return sum


class TestSumOfMultiplesOf3And5(unittest.TestCase):
    # Fail test:
    def test_fail(self):
        self.assertEqual(233190, sum_of_multiples_of_3_and_5(1, 1000))

    # Pass test:
    def test_pass(self):
        self.assertEqual(233168, sum_of_multiples_of_3_and_5(1, 1000))


if __name__ == '__main__':
    unittest.main()
