import java.io.*;
import java.util.*;

public abstract class AbstractRun {
	static {
		System.out.println("輸出全部單字，計算 TF 與 DF");
		System.out.println("將個別單字的 TF 轉成稀疏矩陣");
		System.out.println("=========================");
	}

	final File folder = new File("E:\\data");
	final File[] f1 = folder.listFiles();

	int i;

	public void start() throws IOException {

		// tfxdf.countRun();
		for (i = 0; i < folder.listFiles().length; i++) {

			Scanner sc = new Scanner(f1[i]);

			countTF(sc);
			
			findWordSize();

			countDF();

			sc.close();
			System.out.println("-----------------------");
		} // end of for

		ArraySort();

	}// end of start
	
	public void start2() throws IOException {
		
		// int array[字詞總數][檔案總數];
		int array[][] = new int[ExtendsRun.tmpMax][folder.listFiles().length];
		
		for (i = 0; i < folder.listFiles().length; i++) {
			System.out.println("FileName : " + f1[i].getName()); // 01.txt
			Scanner sc = new Scanner(f1[i]);

			countTF(sc);
			
			// saveArray();
			for (int j = 0; j < ExtendsRun.wordList.size(); j++) {
				array[j][i] = ExtendsRun.tf.get(j);
			}

			sc.close();
			System.out.println("-----------------------");
		}
		
		printArray(array);
		
		// (int maxSize, int maxRow, int maxCol, int[][] array) 
		sMatrix arr = new sMatrix(ExtendsRun.tmpMax*folder.listFiles().length, ExtendsRun.tmpMax, folder.listFiles().length, array);
		arr.printMatrix();
		
	}


	protected abstract void countTF(Scanner read);
	protected abstract void countDF();
	protected abstract void printTotal();
	
	protected abstract void findWordSize();          // 每個檔案的單字數量存進陣列
	protected abstract void ArraySort();             // 找資料庫單字數量的最大值

	protected abstract void printArray(int[][] array);  // 印出個別檔案的 TF

}// END
