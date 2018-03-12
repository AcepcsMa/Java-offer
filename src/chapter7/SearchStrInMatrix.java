package chapter7;

public class SearchStrInMatrix {

	public static void main(String[] args) {
		char[][] board = {
			{'a', 'b', 'c', 'e'},
			{'s', 'f', 'c', 's'},
			{'a', 'd', 'e', 'e'}
		};
		String s = "asfcsee";
		System.out.println(searchStrInMatrix(s, board));
	}

	/**
	 * 在矩阵中搜索目标字符串
	 * @param s 目标字符串
	 * @param board 矩阵
	 * @return true/false
	 */
	public static boolean searchStrInMatrix(String s, char[][] board) {
		boolean[][] isVisited = new boolean[board.length][board[0].length];
		for(int i = 0;i < board.length;i++) {
			for(int j = 0;j < board[0].length;j++) {
				if(s.charAt(0) == board[i][j] && dfs(s, 0, board, isVisited, i, j)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 使用dfs搜索路径
	 * @param s 字符串
	 * @param index 当前index
	 * @param board matrix
	 * @param isVisited 记录是否访问
	 * @param i 当前i
	 * @param j 当前j
	 * @return true/false
	 */
	public static boolean dfs(String s, int index, char[][] board, boolean[][] isVisited, int i, int j) {
		if(index == s.length()) {
			return true;
		}

		if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != s.charAt(index) || isVisited[i][j]) {
			return false;
		}

		isVisited[i][j] = true;
		if(dfs(s, index + 1, board, isVisited, i, j - 1)
			|| dfs(s, index + 1, board, isVisited, i - 1, j)
			|| dfs(s, index + 1, board, isVisited, i, j + 1)
			|| dfs(s, index + 1, board, isVisited, i + 1, j)) {
			return true;
		}
		isVisited[i][j] = false;
		return false;
	}
}
