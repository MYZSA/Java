package IOgreate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
/*
 * 将gbk文件转换为utf-8文件
 */

public class zhuanHuanLiu {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入要转换的文件源路径：");
		String src = sc.nextLine();
		String dest = creatDest(src);
		gbkToUtf8(src, dest);
		System.out.println("转换完成！");
	
		
		

	}
	public static void gbkToUtf8(String src,String dest) throws IOException {
		InputStreamReader isr = new InputStreamReader(new FileInputStream(src),"gbk");
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(dest),"utf-8");
		
		char[] c = new char[1024];
		int len;
		while((len = isr.read(c)) != -1){
			osw.write(c, 0, len);
		}
		osw.close();
		isr.close();
		
	}
	//创建输出文件
	public static String creatDest(String src) throws IOException{
		//拼接输出文件路径
		int index = src.indexOf(".");
		String dest;
		if (index != -1){
			StringBuffer sb = new StringBuffer(src);
			sb.insert(index, "[utf8]");
			dest = sb.toString();
			//创建输出文件
			new File(dest).createNewFile();
		}else {
			dest = src;
		}
		
		
		return dest;
	}

}
