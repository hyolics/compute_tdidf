import java.io.*;
import java.util.*;

public abstract class AbstractRun {
	static {
		System.out.println("��X������r�A�p�� TF �P DF");
		System.out.println("�N�ӧO��r�� TF �ন�}���x�}");
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
		
		// int array[�r���`��][�ɮ��`��];
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
	
	protected abstract void findWordSize();          // �C���ɮת���r�ƶq�s�i�}�C
	protected abstract void ArraySort();             // ���Ʈw��r�ƶq���̤j��

	protected abstract void printArray(int[][] array);  // �L�X�ӧO�ɮת� TF

}// END
