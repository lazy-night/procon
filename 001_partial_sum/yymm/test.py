import unittest
from partial_sum import PartialSum

class TestPartialSum(unittest.TestCase):

    def test_run_case1(self):
        n = 4
        a = [1,2,4,7]
        k = 13
        p = PartialSum(n, a, k)
        self.assertEqual(True, p.run())

    def test_run_case2(self):
        n = 4
        a = [1,2,4,7]
        k = 18
        p = PartialSum(n, a, k)
        self.assertEqual(False, p.run())

    def test_run_case3(self):
        n = 4
        a = [5,6,8,9,10,4]
        k = 19
        p = PartialSum(n, a, k)
        self.assertEqual(True, p.run())

if __name__ == '__main__':
    #unittest.main()
    suite = unittest.TestLoader().loadTestsFromTestCase(TestPartialSum)
    unittest.TextTestRunner(verbosity=2).run(suite)
