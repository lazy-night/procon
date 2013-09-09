class PartialSum:

    def __init__(self, n, a, k):
        self.n = n
        self.a = a
        self.k = k

    def run(self): 
        """doctest!
        >>> n = 4
        >>> a = [1,2,4,7]
        >>> k = 15
        >>> p = PartialSum(n, a, k)
        >>> p.run()
        True
        """
        return self.__recursive__(self.a[0], [0])

    def __recursive__(self, summary, arr):
        if summary == self.k:
            return True
        if arr[0] == self.n - 1:
            return False
        if summary > self.k or arr[-1] == self.n - 1:
            summary -= self.a[arr.pop(-1)] + self.a[arr[-1]]
            arr[-1] = arr[-1] + 1
            summary += self.a[arr[-1]]
            return self.__recursive__(summary, arr)
        if summary < self.k:
            summary += self.a[arr[-1]+1]            
            arr.append(arr[-1]+1)
            return self.__recursive__(summary, arr)

if __name__ == "__main__":
    import doctest
    doctest.testmod()
