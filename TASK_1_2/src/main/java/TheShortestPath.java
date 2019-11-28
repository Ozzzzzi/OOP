public class TheShortestPath {

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
