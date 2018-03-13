package chapter7;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 机器人运动范围
 */
public class RobotMoveCount {

	public static void main(String[] args) {
		System.out.println(robotMoveCount2(3, 3, 5));
	}

	/**
	 * 给定一个m行n列的矩阵, 计算机器人能够到达其中的多少个格子
	 * @param m m行
	 * @param n n列
	 * @param k 限制条件k
	 * @return 可到达的格子数
	 */
	public static int robotMoveCount1(int m, int n, int k) {
		boolean[][] isVisited = new boolean[m][n];
		return dfs(m, n, 0, 0, isVisited, k);
	}

	/**
	 * 递归dfs
	 * @param m m行
	 * @param n n列
	 * @param i 当前i
	 * @param j 当前j
	 * @param isVisited 访问历史记录
	 * @param k 限制条件k
	 * @return 从当前格子出发能到达的格子数
	 */
	public static int dfs(int m, int n, int i, int j, boolean[][] isVisited, int k) {

		// 越界 or 已经访问过
		if(i < 0 || j < 0 || i >= m || j >= n || isVisited[i][j]) {
			return 0;
		}

		// 不满足k的限制
		if(!isValid(i, j, k)) {
			return 0;
		}

		// 没访问过且满足k的限制
		isVisited[i][j] = true;
		int count = 1;
		count += (dfs(m, n, i, j - 1, isVisited, k)
				 + dfs(m, n, i - 1, j, isVisited, k)
				 + dfs(m, n, i, j + 1, isVisited, k)
				 + dfs(m, n, i + 1, j, isVisited, k));
		return count;
	}

	public static boolean isValid(int num1, int num2, int k) {
		int sum = 0;
		while(num1 > 0) {
			sum += num1 % 10;
			num1 /= 10;
		}
		while(num2 > 0) {
			sum += num2 % 10;
			num2 /= 10;
		}
		return !(sum > k);
	}

	/**
	 * 循环bfs
	 * @param m m行
	 * @param n n列
	 * @param k 限制条件k
	 * @return 可到达的格子数
	 */
	public static int robotMoveCount2(int m, int n, int k) {
		if(m <= 0 || n <= 0 || k <= 0) {
			return 0;
		}

		int count = 0;
		boolean[][] isVisited = new boolean[m][n];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{0, 0});

		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			if(isVisited[cur[0]][cur[1]] == false) {
				isVisited[cur[0]][cur[1]] = true;
				count++;
			}
			if(checkPosition(cur[0], cur[1] - 1, isVisited, k)) {
				queue.add(new int[]{cur[0], cur[1] - 1}); // 左
			}
			if(checkPosition(cur[0] - 1, cur[1], isVisited, k)) {
				queue.add(new int[]{cur[0] - 1, cur[1]}); // 上
			}
			if(checkPosition(cur[0], cur[1] + 1, isVisited, k)) {
				queue.add(new int[]{cur[0], cur[1] + 1}); // 右
			}
			if(checkPosition(cur[0] + 1, cur[1], isVisited, k)) {
				queue.add(new int[]{cur[0] + 1, cur[1]}); // 下
			}
		}
		return count;
	}

	public static boolean checkPosition(int i, int j, boolean[][] isVisited, int k) {

		if(i < 0 || j < 0 || i >= isVisited.length || j >= isVisited[0].length || isVisited[i][j]) {
			return false;
		}
		int sum = 0;
		while(i > 0) {
			sum += i % 10;
			i /= 10;
		}
		while(j > 0) {
			sum += j % 10;
			j /= 10;
		}
		return !(sum > k);
	}
}
