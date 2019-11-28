import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.assertArrayEquals;

public class TestTSP {
    @Test
    public void testTSP() throws FileNotFoundException {
        File input = new File("./src/test/resources/input.txt");
        File result = new File("./src/test/resources/result.txt");

        TheShortestPath test = new TheShortestPath();

        Scanner scan_in = new Scanner(input);
        Scanner scan_res = new Scanner(result);

        int test_num = scan_in.nextInt();

        int[] testMtx = new int[test_num];
        int[] resMtx =  new int[test_num];

        for (int k = 0; k < test_num; k++) {
            int vNum = scan_in.nextInt();
            int[][]adjMtx = new int[vNum][vNum];

            int startV = scan_in.nextInt();
            int endV = scan_in.nextInt();

            for (int i = 0; i < vNum; i++) {
                for (int j = 0; j < vNum; j++) {
                    adjMtx[i][j] = scan_in.nextInt();
                }
            }

            testMtx[k] = test.findPath(vNum, adjMtx, startV, endV);
            resMtx[k] = scan_res.nextInt();
        }

        assertArrayEquals(testMtx, resMtx);

        scan_in.close();
        scan_res.close();

    }
}
