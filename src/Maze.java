import java.util.ArrayList;
import java.util.List;

public class Maze {

	private int sizeX;
	private int sizeY;
	private Node startNode;
	private Node goalNode;
	
	private Node[][] maze;

	public Maze(int sizeX, int sizeY, Node startNode, Node goalNode) {
		super();
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.maze = new Node[sizeX][sizeY];
		this.startNode = startNode;
		this.goalNode = goalNode;
		
		for(int i = 0; i < sizeX; i++) {
			for(int j = 0; j < sizeY; j++) {
				maze[i][j] = new Node(new Coordinate(i, j), NodeType.ROAD);
			}
		}
		
		Coordinate goalCoordinate = goalNode.getCoordinate();
		maze[goalCoordinate.getX()][goalCoordinate.getY()].setType(NodeType.GOAL);
		
	}

	public int getSizeX() {
		return sizeX;
	}

	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}

	public Node[][] getMaze() {
		return maze;
	}

	public void setMaze(Node[][] maze) {
		this.maze = maze;
	}

	public Node getStartNode() {
		return startNode;
	}

	public void setStartNode(Node startNode) {
		this.startNode = startNode;
	}

	public Node getGoalNode() {
		return goalNode;
	}

	public void setGoalNode(Node goalNode) {
		this.goalNode = goalNode;
	}

	public boolean isLocationInBounds(Coordinate coordinate) {
		int x = coordinate.getX();
		int y = coordinate.getY();
		return (x < sizeX && y < sizeY) && (x >= 0 && y >= 0); 
	}

	public boolean isObstacle(Node currentNode) {
		return currentNode.getType() == NodeType.OBSTACLE;
	}

	public boolean isAlreadyExplored(Node currentNode) {
		return currentNode.isExplored();
	}

	public List<Node> getValidNeighbors(Node currentNode) {
		List<Node> validNeighbors = new ArrayList<Node>();
		
		Coordinate left = new Coordinate(currentNode.getCoordinate().getX(), currentNode.getCoordinate().getY() - 1);
		Coordinate right = new Coordinate(currentNode.getCoordinate().getX(), currentNode.getCoordinate().getY() + 1);
		Coordinate up = new Coordinate(currentNode.getCoordinate().getX() - 1, currentNode.getCoordinate().getY());
		Coordinate down = new Coordinate(currentNode.getCoordinate().getX() + 1, currentNode.getCoordinate().getY());
		
		if(isLocationInBounds(left)) {
			Node leftNode = new Node(left, maze[left.getX()][left.getY()].getType());
			validNeighbors.add(leftNode);
		}
		if(isLocationInBounds(right)) {
			Node rightNode = new Node(right, maze[right.getX()][right.getY()].getType());
			validNeighbors.add(rightNode);
		}
		if(isLocationInBounds(up)) {
			Node upNode = new Node(up, maze[up.getX()][up.getY()].getType());
			validNeighbors.add(upNode);
		}
		if(isLocationInBounds(down)) {
			Node downNode = new Node(down, maze[down.getX()][down.getY()].getType());
			validNeighbors.add(downNode);
		}
		
		return validNeighbors;
	}

	

	
	
	
}
