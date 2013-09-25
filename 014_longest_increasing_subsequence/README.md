Longest increasing subsequence Problem
----

長さnの数列a0, a1, ..., an-1があります。
この数列のうち、最長のものの長さを求めなさい。
ただし、増加部分列とは、全てのi<jでai<ajを満たす部分列のことを言います。

制約

* 1 <= n <= 1000
* 0 <= ai <= 1000000

## 例

    n = 5
    a = {4, 2, 3, 1, 5}

が与えられた時、

    3(a1, a2, a4からなる部分列2, 3, 5が最長)

が答えとなる。

## 出題

蟻本 p.63