import java.util.List;

public class Node {

	private Coordinate coordinate;
	private NodeType type;
	private boolean explored;
	
	public Node(Coordinate coordinate, NodeType type) {
		this.coordinate = coordinate;
		this.type = type;
		this.explored = false;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public NodeType getType() {
		return type;
	}

	public void setType(NodeType type) {
		this.type = type;
	}

	public boolean isExplored() {
		return explored;
	}

	public void setExplored(boolean explored) {
		this.explored = explored;
	}

	public boolean isExit() {
		return this.type == NodeType.GOAL;
	}

	@Override
	public String toString() {
		return "Node [coordinate=" + coordinate + ", type=" + type + ", explored=" + explored + "]";
	}
	
	

}
