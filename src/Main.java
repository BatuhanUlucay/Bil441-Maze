import java.util.List;

public class Main {

	public static void main(String[] args) {

		Node startNode = new Node(new Coordinate(0,0), NodeType.ROAD);
		Node goalNode = new Node(new Coordinate(4,4), NodeType.GOAL);
		
		Maze maze = new Maze(5,5, startNode, goalNode);
		
		Dfs dfs = new Dfs();
		List<Node> solution = dfs.solve(maze);
		
		System.out.println(solution);
		
	}

}
