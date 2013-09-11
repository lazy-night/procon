package lib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
	
	public ArrayList<String> readInputFile(String filename) {
		ArrayList<String> text = new ArrayList<String>();
		try {
			// 入力ストリームの生成
			FileInputStream fis   = new FileInputStream(filename);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br     = new BufferedReader(isr);
			
			// テキストファイルからの読み込み
			String line;
			while ((line = br.readLine()) != null) text.add(line);
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		
		return text;
	}
}
