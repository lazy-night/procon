import unittest
from lake_counting import LakeCounting

class TestLakeCounting(unittest.TestCase):

    def test_run_case1(self):
        
        input = """10 12
W........WW.
.WWW.....WWW
....WW...WW.
.........WW.
.........W..
..W......W..
.W.W.....WW.
W.W.W.....W.
.W.W......W.
..W.......W."""
        l = LakeCounting(input)
        self.assertEqual(3, l.run())

    def test_run_case2(self):
        
        input = """10 12
W........WW.
.WWW.....WWW
....WW...WW.
.W.......WW.
..W.........
..W......W..
.W.W.....WW.
W.W.W.....W.
.W.W........
..W.......W."""
        l = LakeCounting(input)
        self.assertEqual(5, l.run())

if __name__ == '__main__':
    #unittest.main()
    suite = unittest.TestLoader().loadTestsFromTestCase(TestLakeCounting)
    unittest.TextTestRunner(verbosity=2).run(suite) 
