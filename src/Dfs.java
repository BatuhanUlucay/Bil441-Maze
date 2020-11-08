import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Dfs {

	public List<Node> solve(Maze maze){
		List<Node> pathExplored = new ArrayList<Node>();
		
		if(explore(maze, maze.getStartNode(), pathExplored)) {
			return pathExplored;
		}
		
		return Collections.emptyList();
	}
	
	private boolean explore(Maze maze, Node currentNode, List<Node> currentPath) {
		
		//TODO: Bu methodlari node classina tasiyabiliriz.
		
		if(!maze.isLocationInBounds(currentNode.getCoordinate())) { //never comes here!.
			System.out.println("Node with coordinate (" + currentNode.getCoordinate().getX() + "," + currentNode.getCoordinate().getY() + ") is out of bounds!" );
			return false;
		}
		else if(maze.isObstacle(currentNode)) {
			System.out.println("Oops! Node with coordinate (" + currentNode.getCoordinate().getX() + "," + currentNode.getCoordinate().getY() + ") is a wall!" );
			return false;
		}
		else if(maze.isAlreadyExplored(currentNode)) {
			System.out.println("Node with coordinate (" + currentNode.getCoordinate().getX() + "," + currentNode.getCoordinate().getY() + ") is already discovered before!" );
			return false;
		}
		
		currentNode.setExplored(true);
		currentPath.add(maze.getMaze()[currentNode.getCoordinate().getX()][currentNode.getCoordinate().getY()]);
		maze.getMaze()[currentNode.getCoordinate().getX()][currentNode.getCoordinate().getY()].setExplored(true);
		
		if(currentNode.isExit()) {
			return true;
		}
		
		List<Node> neighborNodes = maze.getValidNeighbors(currentNode);
		
		for (Iterator<Node> iterator = neighborNodes.iterator(); iterator.hasNext(); ) {
		    Node n = iterator.next();
		    if (maze.getMaze()[n.getCoordinate().getX()][n.getCoordinate().getY()].isExplored()) {
		        iterator.remove();
		    }
		}
		
		for(Node neighbor : neighborNodes) {
			if(explore(maze, neighbor, currentPath)) {
				return true;
			}
		}
		
		currentPath.remove(currentNode);
		return false;
	}
}
