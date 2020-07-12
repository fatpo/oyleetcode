- [二叉树](#二叉树)
  * [dfs](#dfs)
    + [反转二叉树](#反转二叉树)
  * [bfs](#bfs)
    + [二叉树宽度](#二叉树宽度)
- [动态规划](#动态规划)
  * [简单的转移方程](#简单的转移方程)
    + [爬楼梯](#爬楼梯)
  * [博弈](#博弈)
    + [石子游戏](#石子游戏)


# 二叉树
## dfs
### 反转二叉树
```
root.left, root.right = dfs(root.right), dfs(root.left)
```
## bfs
### 二叉树宽度
```
ans = 0
curLevel = 1
pos = 0
queue = [root, curLevel, pos]
while !queue.isEmpty():
  node, level, pos = queue.poll()
  # 确定最左的点
  if level != curLevel:
    leftIndex = pos
    curLevel = level
    
  ans = Math.max(ans, pos - leftIndex)
  if root.left:
    queue.offer([root.left, level + 1, 2 * pos])
  if root.right:
    queue.offer([root.right, level + 1, 2 * pos + 1])
return ans

```

# 动态规划
## 简单的转移方程
### 爬楼梯
可走一步或者两步，到达n阶梯一共有多少种走法？
```
dp[i] = dp[i-1] + dp[i-2]
```
## 博弈
### 石子游戏
这个巴什博弈，难搞。
