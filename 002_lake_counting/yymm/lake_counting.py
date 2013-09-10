import re

class LakeCounting:

    def __init__(self, input):
        self.field = []
        self.read_input(input)
    
    def read_input(self, input):
        lines = input.splitlines()
        for line in lines:
            if re.search(r'[W|.]+?', line) == None:
                words = line.split(' ')
                self.m = int(words[0])
                self.n = int(words[1])
            else:
                self.field.append(list(line))

    def run(self):
        """ Lake Counting
            W : water
            . : dry land
        >>> input = \"\"\"10 12
        ... W........WW.
        ... .WWW.....WWW
        ... ....WW...WW.
        ... .........WW.
        ... .........W..
        ... ..W......W..
        ... .W.W.....WW.
        ... W.W.W.....W.
        ... .W.W......W.
        ... ..W.......W.\"\"\"
        >>> l = LakeCounting(input)
        >>> l.run()
        3
        """
        return self.__search_lake__()

    def __search_lake__(self):
        count = 0
        for row, street in enumerate(self.field):
            for column, block in enumerate(street):
                if block == 'W':
                    lake = []
                    self.__search_around__(row, column, lake)
                    self.__dryup_lake__(lake)
                    count += 1
        return count

    def __search_around__(self, row, column, lake):
        lake.append([row, column])
        pos_list = [(-1,0), (-1,-1), (0,-1), (1,-1), (1,0), (1,1), (0,1), (-1,1)]
        for pos in pos_list:
            try:
                if row + pos[0] < 0 or column + pos[1] < 0:
                    continue
                if self.field[row + pos[0]][column + pos[1]] == 'W':
                    if self.__is_found_lake__(row + pos[0], column + pos[1], lake):
                        continue
                    self.__search_around__(row + pos[0], column + pos[1], lake)
            except:
                continue
        return

    def __dryup_lake__(self, lake):
        for block in lake:
            self.field[block[0]][block[1]] = '.'

    def __is_found_lake__(self, row, column, lake):
        for block in lake:
            if block[0] == row and block[1] == column:
                return True
        return False
    
if __name__ == "__main__":
    import doctest
    doctest.testmod()
