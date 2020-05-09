package IOgreate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import IOdemo.fileDemo;

public class copyDerectory {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入要复制的目录：");
		String srcname = scanner.nextLine();
		//拼接输出文件夹
		String destname = srcname+"[副本]";
		System.out.println(File.separator);
		long start = System.currentTimeMillis();
		File file= new File(destname);
		file.mkdirs();
		System.out.println(file.toString());
		copyderectory(srcname, destname);
		
		long end = System.currentTimeMillis();
		System.out.println("复制该文件夹共耗时"+(end-start));
		
		

	}
	public static void copyderectory(String srcname,String destname) throws IOException {
		File src = new File(srcname);
		File[] files = src.listFiles();
		for (File file : files) {
			if(file.isFile()){
				//拼接输出文件,创建输出文件
				String shuchu = destname+File.separator+(file.getName());
				File sc = new File(shuchu);
				sc.createNewFile();
				String shuru = srcname+File.separator+(file.getName());
				File src1 = new File(shuru);
				//创建字节输入输出流
				FileOutputStream fos = new FileOutputStream(sc);
				FileInputStream fis = new FileInputStream(src1);
				//写入数据
				byte[] b = new byte[1024*6];
				int len;
				while((len = fis.read(b)) != -1){
					fos.write(b, 0, len);
				}
				//释放资源
				fos.close();
				fis.close();
				
			}else {
				//
				String shuchu = destname+file.separator+(file.getName());
				File sc = new File(shuchu);
				sc.mkdirs();
				String shuru = srcname+File.separator+(file.getName());
				copyderectory(shuru,shuchu );
				
			}
		}
	}

}
