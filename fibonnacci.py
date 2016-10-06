def fibonnacci(num):
    a, b = 1, 1
    total = 0
    while a <= num:
        if a % 2 == 0:
            total = total + a
        a, b = b, a + b
    return (total)


import unittest


class fibonaccieven(unittest.TestCase):
    def test1(self):
        self.assertEqual(89653, fibonnacci(4000000))

    def test2(self):
        self.assertEqual(123654, fibonnacci(4000000))

    def test3(self):
        self.assertEqual(4613732, fibonnacci(4000000))


if __name__ == '__main__':
    unittest.main()
