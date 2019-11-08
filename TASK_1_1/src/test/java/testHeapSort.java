import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static org.junit.Assert.*;

public class testHeapSort {
    @Test
    public void heapsortTest() throws FileNotFoundException {
        File file = new File("./src/test/resources/test.txt");
        File result = new File("./src/test/resources/sortedTest.txt");

        Scanner scanner = new Scanner(file);
        Scanner scan = new Scanner(result);

        int test_num = scanner.nextInt();

        for (int i = 0; i < test_num; i++) {
            int el_num = scanner.nextInt();

            int[] tested = new int[el_num];
            int[] res = new int[el_num];

            for (int j = 0; j < el_num; j++) {
                tested[j] = scanner.nextInt();
                res[j] = scan.nextInt();
            }

            HeapSort.sort(tested);

            assertArrayEquals(res, tested);

        }

        scanner.close();
        scan.close();

    }
}
