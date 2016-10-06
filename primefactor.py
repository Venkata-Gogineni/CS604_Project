def primefactor(n):

    i = 2
    while i * i < n:
        while n % i == 0:
            n = n / i
        i = i + 1
    return n


import unittest

class primefactortest(unittest.TestCase):
    def test1(self):
        self.assertEqual(6857, primefactor(600851475143))
    def test2(self):
        self.assertEqual(23,primefactor(600851475143))
    def test3(self):
        self.assertEqual(236985635, primefactor(600851475143))

if __name__=='__main__':
    unittest.main()