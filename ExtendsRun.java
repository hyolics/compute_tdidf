import java.util.*;

public class ExtendsRun extends AbstractRun {
	static List<String> wordList;
	List<Integer> sum;
	static List<Integer> tf;
	List<Integer> df;

	int tmpTFGet = 0;

	static int tmpMax = 0;

	int wordSize[] = new int[folder.listFiles().length];

	public ExtendsRun() {
		wordList = new LinkedList<String>();
		sum = new LinkedList<Integer>();
		tf = new LinkedList<Integer>();
		df = new LinkedList<Integer>();
	}

	public void countTF(Scanner read) {

		// set0
		for (int j = 0; j < tf.size(); j++) {
			tf.set(j, 0);
		}

		while (read.hasNext()) { // 判斷是否有下一個元素，是則傳 true

			String strTmp = read.next(); // 每個元素
			// System.out.print(strTmp + " ");
			strTmp = strTmp.replaceAll("[.|,|\"|?|!]", ""); // 取代標點符號

			// int intTmp = 0;
			int intTmp = wordList.indexOf(strTmp); // 取得特定元素位置

			if (intTmp == -1) { // 判斷字串陣列中沒有有此字串，-1 表示不存在
				wordList.add(strTmp);
				sum.add(1);

				tf.add(1);

			} else { // 如果有重複單字
				int tmp = sum.get(intTmp); // 此字串的位置的 count 內容
				sum.set(intTmp, tmp + 1); // count 位置內的記數 + 1

				int tmpTF = tf.get(intTmp);
				tf.set(intTmp, tmpTF + 1);

			} // end of else

		} // end of while

		// cnt1.printTF();
		for (int j = 0; j < wordList.size(); j++) {

			/*
			 * System.out.print("\t" + (j + 1)); System.out.print("\t" +
			 * wordList.get(j)); System.out.print("\t" + tf.get(j));
			 * System.out.println("\t次");
			 */

			df.add(1);
		} // end of for

	}// end of countRunF


	public void countDF() {

		for (int j = 0; j < wordList.size(); j++) {
			if (tf.get(j) > 1) {
				tf.set(j, 1);
			}

			// System.out.println(tf.get(j));
			tmpTFGet = tf.get(j);
			int tmpDFGet = df.get(j);

			df.set(j, tmpTFGet + tmpDFGet);

			// System.out.println("df=" + df.get(j));
		} // end of for
	} // end of countDF

	public void printTotal() {

		for (int j = 0; j < wordList.size(); j++) {
			System.out.println("----------------------------------------------");

			System.out.print(" " + (j + 1));
			System.out.print("\t" + wordList.get(j));
			System.out.print("\t共  " + sum.get(j) + "  次");

			System.out.println("   [DF]= " + (df.get(j) - 1));

		} // end of for
		System.out.println("----------------------------------------------");
	}// end of printTotal

	
	public void printArray(int[][] array) {

		for (int a = 0; a < array.length; a++) {
			System.out.print(wordList.get(a) + "\t |  ");

			for (int b = 0; b < array[a].length; b++) {
				System.out.print(array[a][b] + "\t");
			}
			System.out.println();
		}

		/*
		System.out.println("----------printFormat----------");
		for (int[] row : array) {
			System.out.print("***  ");
			for (int element : row) {
				System.out.print(element + "    ");
			}
			System.out.println();
		} // end of foreach
		*/

	}// end of printArray

	public void findWordSize() {
		wordSize[i] = wordList.size();
		// System.out.println( "SIZE" + wordSize[i]);
	}

	public void ArraySort() {

		// int tmpMax = 0;
		tmpMax = wordSize[0]; // 先將陣列的第一個值視為最大值

		for (int x = 0; x < wordSize.length; x++) {
			if (wordSize[x] > tmpMax) {
				tmpMax = wordSize[x];
			} // end of if
		} // end of for

		// System.out.println("MAX:" + tmpMax);
	}

}// END
