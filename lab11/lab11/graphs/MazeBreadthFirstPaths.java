package lab11.graphs;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 *  @author Josh Hug
 */
public class MazeBreadthFirstPaths extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;

    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        // Add more variables here!
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;


    }

    /** Conducts a breadth first search of the maze starting at the source. */
    private void bfs() {
        // TODO: Your code here. Don't forget to update distTo, edgeTo, and marked, as well as call announce()
       Queue<Integer> q = new ArrayDeque<>();
       q.add(s);
       while(!q.isEmpty()){
           int frontier = q.remove();
           marked[frontier] = true;
           announce();
           if(frontier == t){
               targetFound = true;
               break;
           }
           for(int w: maze.adj(frontier)){
               if(!marked[w]){
                   distTo[w] = distTo[frontier] + 1;
                   edgeTo[w] = frontier;
                   announce();
                   q.add(w);
               }
           }
       }
    }


    @Override
    public void solve() {
        bfs();
    }
}

