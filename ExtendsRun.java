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

		while (read.hasNext()) { // �P�_�O�_���U�@�Ӥ����A�O�h�� true

			String strTmp = read.next(); // �C�Ӥ���
			// System.out.print(strTmp + " ");
			strTmp = strTmp.replaceAll("[.|,|\"|?|!]", ""); // ���N���I�Ÿ�

			// int intTmp = 0;
			int intTmp = wordList.indexOf(strTmp); // ���o�S�w������m

			if (intTmp == -1) { // �P�_�r��}�C���S�������r��A-1 ��ܤ��s�b
				wordList.add(strTmp);
				sum.add(1);

				tf.add(1);

			} else { // �p�G�����Ƴ�r
				int tmp = sum.get(intTmp); // ���r�ꪺ��m�� count ���e
				sum.set(intTmp, tmp + 1); // count ��m�����O�� + 1

				int tmpTF = tf.get(intTmp);
				tf.set(intTmp, tmpTF + 1);

			} // end of else

		} // end of while

		// cnt1.printTF();
		for (int j = 0; j < wordList.size(); j++) {

			/*
			 * System.out.print("\t" + (j + 1)); System.out.print("\t" +
			 * wordList.get(j)); System.out.print("\t" + tf.get(j));
			 * System.out.println("\t��");
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
			System.out.print("\t�@  " + sum.get(j) + "  ��");

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
		tmpMax = wordSize[0]; // ���N�}�C���Ĥ@�ӭȵ����̤j��

		for (int x = 0; x < wordSize.length; x++) {
			if (wordSize[x] > tmpMax) {
				tmpMax = wordSize[x];
			} // end of if
		} // end of for

		// System.out.println("MAX:" + tmpMax);
	}

}// END
