# [LeetCode] 63. Unique Paths II (Java)

## 들어가며

이번 문제는 `Unique Paths` 문제의 확장 버전이다.  
기본 문제에서는 로봇이 오른쪽 또는 아래쪽으로만 이동할 수 있었고, 시작점에서 도착점까지 가는 모든 경우의 수를 구하면 됐다.

하지만 이번 문제는 중간에 `장애물(obstacle)`이 추가된다.  
즉, 단순히 이동 경로를 누적하는 것이 아니라 장애물이 있는 칸은 지나갈 수 없다는 조건까지 함께 고려해야 한다.

문제를 보자마자 떠오른 건 결국 각 칸까지 오는 방법의 수를 저장해두는 방식이었다.  
그래서 2차원 배열을 이용한 DP로 접근했다.

---

## 문제 설명

`m x n` 크기의 격자가 주어지고,

- 로봇은 왼쪽 위 `(0, 0)` 에서 시작
- 오른쪽 아래 `(m - 1, n - 1)` 까지 이동
- 이동은 오른쪽, 아래쪽만 가능
- `1`은 장애물, `0`은 빈 칸

이때 도착점까지 갈 수 있는 서로 다른 경로의 수를 구하는 문제다.

---

## 접근 방법

### 1. 각 칸까지 오는 경로 수를 저장하자

어떤 칸 `(row, col)` 에 도착하는 방법은 딱 두 가지뿐이다.

- 위쪽 칸 `(row - 1, col)` 에서 내려오기
- 왼쪽 칸 `(row, col - 1)` 에서 오른쪽으로 오기

즉, 장애물이 아니라면 현재 칸까지 오는 경로 수는 다음과 같이 계산할 수 있다.

```java
pathCount[row][col] = pathCount[row - 1][col] + pathCount[row][col - 1];
```

이 점화식이 이 문제의 핵심이다.

---

### 2. 시작점 처리

가장 먼저 확인해야 하는 건 시작점이다.

만약 `(0, 0)` 자체가 장애물이면 로봇은 출발조차 못 한다.  
이 경우 정답은 바로 `0`이다.

```java
if (obstacleGrid[0][0] == 1) {
    return 0;
}
```

시작점이 비어 있다면 시작 위치에 도달하는 경우의 수는 `1`이므로 다음처럼 둔다.

```java
pathCount[0][0] = 1;
```

---

### 3. 첫 행과 첫 열 초기화

첫 행은 위에서 내려올 수 없고, 왼쪽에서만 올 수 있다.  
즉, 첫 행의 어떤 칸이 장애물이 아니라면 바로 왼쪽 칸의 값을 그대로 이어받는다.

```java
pathCount[0][col] = obstacle ? 0 : pathCount[0][col - 1];
```

첫 열도 마찬가지다.  
왼쪽에서 올 수 없으므로 위 칸의 값을 이어받는다.

```java
pathCount[row][0] = obstacle ? 0 : pathCount[row - 1][0];
```

이 부분이 중요하다.  
첫 행과 첫 열은 단순히 장애물이 아니라고 해서 `1`을 넣으면 안 되고, 실제로 이전 칸에서 도달 가능한지를 반영해야 한다.

예를 들어 첫 행 중간에 장애물이 하나 나오면, 그 뒤 칸들은 전부 갈 수 없게 된다.

---

### 4. 나머지 칸 채우기

이제 `(1, 1)` 부터 끝까지 순회하면서 값을 채우면 된다.

- 현재 칸이 장애물이면 `0`
- 아니라면 `위쪽 + 왼쪽`

```java
if (obstacleGrid[row][col] == 1) {
    pathCount[row][col] = 0;
} else {
    pathCount[row][col] = pathCount[row - 1][col] + pathCount[row][col - 1];
}
```

---

## 전체 코드

```java
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[][] pathCount = new int[rows][cols];

        if (isBlocked(0, 0, obstacleGrid)) {
            return 0;
        }

        pathCount[0][0] = 1;

        for (int col = 1; col < cols; col++) {
            pathCount[0][col] = isBlocked(0, col, obstacleGrid)
                    ? 0
                    : pathCount[0][col - 1];
        }

        for (int row = 1; row < rows; row++) {
            pathCount[row][0] = isBlocked(row, 0, obstacleGrid)
                    ? 0
                    : pathCount[row - 1][0];
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                pathCount[row][col] = isBlocked(row, col, obstacleGrid)
                        ? 0
                        : pathCount[row - 1][col] + pathCount[row][col - 1];
            }
        }

        return pathCount[rows - 1][cols - 1];
    }

    private boolean isBlocked(int row, int col, int[][] obstacleGrid) {
        return obstacleGrid[row][col] == 1;
    }
}
```

---

## 예시로 흐름 보기

예를 들어 다음 입력이 있다고 하자.

```java
[[0,0,0],
 [0,1,0],
 [0,0,0]]
```

장애물을 제외하고 각 칸까지 오는 경로 수를 채우면 다음처럼 된다.

```java
[1,1,1]
[1,0,1]
[1,1,2]
```

마지막 칸의 값이 `2`이므로 정답은 `2`다.

---

## 시간복잡도

- 시간복잡도: `O(m * n)`
- 공간복잡도: `O(m * n)`

격자의 모든 칸을 한 번씩만 확인하므로 충분히 빠르다.  
문제의 제한이 `100 x 100` 이기 때문에 시간적으로도 전혀 부담이 없다.

---

## 정리

이 문제는 결국 각 칸까지 오는 경로 수를 누적하는 전형적인 DP 문제다.

핵심은 세 가지였다.

- 시작점이 막혀 있으면 바로 `0`
- 첫 행과 첫 열은 이전 칸의 값을 이어받아 초기화
- 나머지 칸은 `위 + 왼쪽`, 장애물이면 `0`

처음 보면 단순해 보이지만, 첫 행과 첫 열 초기화를 잘못하면 반례가 바로 생긴다.  
그래서 구현할 때는 점화식보다도 초기값 처리를 더 조심해야 하는 문제였다.
