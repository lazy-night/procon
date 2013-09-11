package lib;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
* ファイル操作を行うクラス
*/
public class ControllFile {
	/** 
	 * ファイル読み込みを行う
	 *
	 * @param  String filename
	 * @param  int row
	 * @param  int column
	 * 
	 * @return  char[][] 読み込んだファイル内容
	 */
	public char[][] readInputFile(String filename, int row, int column) {
		char[][] arrayFile = null;
		
		try {
			File file = new File(filename);
			FileReader fr = new FileReader(file);			// FileReaderオブジェクトの作成
			
			arrayFile = new char[row][column];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					int ch = fr.read();
					if (ch != 10 && ch != 13)
						arrayFile[i][j] = (char) ch;		// 改行コードは除く
					else j--;
				}
			}
			
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		
		return arrayFile;
	}
}
