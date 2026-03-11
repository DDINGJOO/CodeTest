# [LeetCode] 62. Unique Paths 풀이 회고

백트래킹으로 시작해서 메모이제이션 DFS를 거쳐 1차원 DP로 정리한 과정 (Java)

문제 링크: https://leetcode.com/problems/unique-paths/

유형: 백트래킹으로 접근 가능, 하지만 정답 풀이는 다이나믹 프로그래밍

체감 난이도: 처음에는 쉬워 보이는데, "경로를 다 가볼 것인가"와 "상태의 답을 저장할 것인가"를 구분하는 지점이 핵심인 문제

## 1. 문제를 처음 마주했을 때

문제를 처음 보면 가장 먼저 드는 생각은 단순하다.

로봇은 오른쪽 아니면 아래쪽으로만 이동할 수 있으니,
현재 위치에서 두 방향으로 계속 가 보면 결국 모든 경로를 셀 수 있지 않을까?

실제로 이 생각 자체는 틀리지 않았다.
정답을 빠뜨리지 않는다는 점에서는 아주 자연스러운 출발이었다.

다만 이 문제는 "경로를 직접 다 세는 방식"으로는 입력 범위를 버티기 어렵다.

## 2. 내가 처음 잡은 방식: 백트래킹

처음에는 현재 위치를 들고 다니면서,
오른쪽으로 갈 수 있으면 가고
아래로 갈 수 있으면 가고
도착 지점에 도달하면 count를 증가시키는 구조로 풀었다.

이 방식의 장점은 분명하다.

- 문제 조건이 코드에 그대로 드러난다.
- 오른쪽, 아래라는 선택지가 명확해서 재귀 구조가 직관적이다.
- "모든 경우를 다 탐색한다"는 점에서 정답을 놓치지 않는다.

즉, 문제 이해용 첫 풀이로는 꽤 괜찮았다.

## 3. 중간 코드 (통과 실패, Time Limit Exceeded)

중간 단계 코드는 아래와 같았다.

```java
class Solution {
    private static final int RIGHT = 0;
    private static final int DOWN = 1;

    private final int[][] directions = {
        {0, 1},
        {1, 0}
    };

    private int pathCount;

    public int uniquePaths(int m, int n) {
        pathCount = 0;
        int[] currentPosition = {0, 0};
        explorePaths(m, n, currentPosition);
        return pathCount;
    }

    private void explorePaths(int m, int n, int[] currentPosition) {
        if (currentPosition[0] == m - 1 && currentPosition[1] == n - 1) {
            pathCount++;
            return;
        }

        if (canMove(m, n, currentPosition, DOWN)) {
            applyMove(currentPosition, DOWN);
            explorePaths(m, n, currentPosition);
            revertMove(currentPosition, DOWN);
        }

        if (canMove(m, n, currentPosition, RIGHT)) {
            applyMove(currentPosition, RIGHT);
            explorePaths(m, n, currentPosition);
            revertMove(currentPosition, RIGHT);
        }
    }

    private boolean canMove(int m, int n, int[] currentPosition, int direction) {
        return currentPosition[0] + directions[direction][0] < m
            && currentPosition[1] + directions[direction][1] < n;
    }

    private void applyMove(int[] currentPosition, int direction) {
        currentPosition[0] += directions[direction][0];
        currentPosition[1] += directions[direction][1];
    }

    private void revertMove(int[] currentPosition, int direction) {
        currentPosition[0] -= directions[direction][0];
        currentPosition[1] -= directions[direction][1];
    }
}
```

로직만 보면 꽤 그럴듯하다.

- 현재 위치에서 갈 수 있는 방향을 확인하고
- 실제로 이동한 뒤 재귀 호출을 하고
- 호출이 끝나면 다시 원래 위치로 되돌린다

전형적인 백트래킹 패턴이다.

하지만 LeetCode에서는 결국 Time Limit Exceeded가 났다.

여기에 시간초과 스크린샷을 넣으면 흐름이 더 자연스럽다.

`[Time Limit Exceeded 스크린샷 삽입]`

## 4. 왜 시간 초과가 났는가

핵심은 같은 상태를 너무 많이 다시 계산했다는 점이다.

예를 들어 `(2, 3)` 위치에 도달하는 방법은 여러 개다.
그런데 한 번 `(2, 3)`에 도달하고 나면,
거기서 도착점까지 가는 경로 수는 어떤 경로로 들어왔든 항상 같다.

문제는 백트래킹은 이 사실을 활용하지 못한다는 점이다.

즉,

- 위에서 내려와서 `(2, 3)`에 도착해도 다시 탐색
- 왼쪽에서 와서 `(2, 3)`에 도착해도 다시 탐색

결국 `(2, 3)` 이후의 하위 문제를 계속 새로 풀게 된다.

이 순간부터 이 문제는 "경로를 만드는 문제"라기보다
"현재 상태에서 정답이 몇 개인가"를 묻는 문제로 봐야 했다.

## 5. 전환점: 과정을 전부 추적할 필요가 없었다

이번 문제에서 가장 중요했던 깨달음은 이거였다.

이 문제는 **어떻게 여기까지 왔는지**가 중요하지 않다.
중요한 건 **지금 어디에 있는지**뿐이다.

즉, 현재 위치가 `(row, col)`라면
그 이후의 경로 수는 항상 동일하다.

여기서 상태를 이렇게 정의할 수 있다.

```java
countPaths(row, col) = (row, col)에서 도착점까지 가는 경로 수
```

이렇게 생각을 바꾸면,
전역 변수 `count`로 누적할 필요도 없고
백트래킹처럼 모든 경로를 끝까지 따라갈 필요도 없어진다.

이제는 각 상태의 정답을 반환하면 된다.

## 6. 백트래킹에서 메모이제이션 DFS로 바꾸기

백트래킹을 메모이제이션 DFS로 바꿀 때의 핵심은 세 가지였다.

1. 경로를 만드는 함수에서 상태의 답을 반환하는 함수로 바꾼다.
2. 상태를 `(row, col)`로 압축한다.
3. 한 번 계산한 상태는 `memo[row][col]`에 저장한다.

코드는 이렇게 바뀐다.

```java
class Solution {
    private int[][] memo;

    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        return countPaths(0, 0, m, n);
    }

    private int countPaths(int row, int col, int m, int n) {
        if (row == m - 1 && col == n - 1) {
            return 1;
        }

        if (memo[row][col] != 0) {
            return memo[row][col];
        }

        int pathCount = 0;

        if (row + 1 < m) {
            pathCount += countPaths(row + 1, col, m, n);
        }

        if (col + 1 < n) {
            pathCount += countPaths(row, col + 1, m, n);
        }

        memo[row][col] = pathCount;
        return pathCount;
    }
}
```

이 코드는 백트래킹에서 출발한 내 사고 흐름과 가장 가깝다.

- 여전히 DFS 형태다.
- 여전히 아래와 오른쪽으로 뻗는다.
- 다만 같은 좌표를 다시 만나면 저장된 값을 재사용한다.

즉, "가면서 센다"가 아니라 "이 칸의 답을 구한다"로 관점이 바뀐 것이다.

## 7. 최종 코드 (1차원 DP)

메모이제이션 DFS로도 충분히 통과할 수 있지만,
최종적으로는 더 간결한 1차원 DP로 정리했다.

핵심 규칙은 하나다.

현재 칸까지 오는 방법의 수는
`위에서 오는 경우 + 왼쪽에서 오는 경우`이다.

이를 그대로 코드로 옮기면 된다.

```java
class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];

        for (int col = 0; col < n; col++) {
            dp[col] = 1;
        }

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                dp[col] += dp[col - 1];
            }
        }

        return dp[n - 1];
    }
}
```

이 코드의 의미는 다음과 같다.

- 첫 번째 행은 오른쪽으로만 갈 수 있으므로 모두 1
- 첫 번째 열도 아래로만 갈 수 있으므로 모두 1
- 나머지 칸은 `위쪽 값 + 왼쪽 값`

1차원 배열로 줄인 이유는 현재 행을 계산할 때
이전 열의 값과 같은 열의 이전 값만 있으면 충분하기 때문이다.

## 8. 시간 복잡도

처음 백트래킹 코드:

- 시간복잡도: 사실상 경로 수만큼 탐색하므로 조합 수에 비례
- 공간복잡도: 재귀 깊이 기준 `O(m + n)`

메모이제이션 DFS:

- 시간복잡도: `O(m * n)`
- 공간복잡도: `O(m * n)`

최종 1차원 DP:

- 시간복잡도: `O(m * n)`
- 공간복잡도: `O(n)`

성능 차이가 나는 이유는 명확하다.
백트래킹은 같은 칸 이후를 여러 번 풀고,
DP는 각 칸의 답을 한 번만 구한다.

## 9. 이번 문제에서 얻은 것

이번 문제를 풀면서 백트래킹과 DP를 구분하는 감각이 조금 선명해졌다.

백트래킹은 보통 경로 자체를 추적해야 할 때 유리하다.
예를 들어 모든 순열을 만들거나, 모든 배치를 실제로 구성해야 하는 문제는 백트래킹이 자연스럽다.

반면 이번 문제처럼

- 답이 "경우의 수"이고
- 같은 상태에 여러 경로로 다시 도달할 수 있고
- 현재 상태만 같으면 이후 정답도 같다면

그때는 DP 또는 메모이제이션 DFS를 먼저 의심해야 한다.

이번 문제에서 그 기준은 아주 단순했다.

`(row, col) 이후의 경로 수는, 여기까지 어떻게 왔는지와 무관하다.`

이 한 문장이 이 문제의 본질이었다.

## 10. 회고

이번 문제는 처음 백트래킹으로 접근한 게 틀린 게 아니었다.
오히려 그 과정을 거쳤기 때문에 왜 시간 초과가 나는지 더 명확하게 보였다.

처음에는 "일단 모든 길을 가 보면 되지 않을까?"라고 생각했고,
실제로 그 방식으로 정답은 만들 수 있었다.

하지만 중간에 막혔던 지점은,
내가 경로를 다 따라가고 있었지
상태의 답을 계산하고 있지는 않았다는 점이었다.

전환점은 여기였다.

`아, 이 문제는 과정을 모두 트래킹할 필요가 없구나.`

이걸 이해하고 나니
백트래킹에서 메모이제이션 DFS로,
그리고 다시 더 단순한 DP로 옮겨 가는 흐름이 자연스럽게 이어졌다.

결국 이번 문제는 Unique Paths 자체보다도,
언제 백트래킹에서 DP로 사고를 전환해야 하는지를 잘 보여준 문제였다.
