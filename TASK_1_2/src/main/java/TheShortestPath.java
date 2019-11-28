public class TheShortestPath {
    /**
     * Finds the shortest path between <code>startV</code> and <code>endV</code> vertices
     * in the weighted graph.
     * The graph is given by the adjacency matrix <code>adjMtx</code>. It cannot contain edges 
     * with negative weights and loops. The absence of an edge between vertices is -1 value. 
     * Vertex numbering starts with 1.
     * 
     * @param  vNum    number of vertices in the graph
     * @param  adjMtx  adjacency matrix of the graph
     * @param  startV  number of the start vertex 
     * @param  endV    number of the end vertex
     * @return         the shortest distance between <code>startV</code> and <code>endV</code>
     *                 or -1 if there is no path
     */
    public int findPath(int vNum, int[][] adjMtx, int startV, int endV) {
        int INF = Integer.MAX_VALUE / 2;
        int[][] dist = new int[vNum][vNum];
        for (int i = 0; i < vNum; i++) System.arraycopy(adjMtx[i], 0, dist[i], 0, vNum);

        for (int k = 0; k < vNum; k++)
            for (int i = 0; i < vNum; i++)
                for (int j = 0; j < vNum; j++) {
                    if (dist[i][j] == -1) {
                        dist[i][j] = INF;
                    }
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
        if (dist[startV - 1][endV - 1] == INF) {
            return -1;
        } else {
            return dist[startV - 1][endV - 1];
        }
    }
}
