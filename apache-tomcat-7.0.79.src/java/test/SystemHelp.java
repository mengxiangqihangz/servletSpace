package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Map;
/**
 * ��Ȼ����io��ռ��Դ����ô һֱ����io�Է����Ӱ�����
 * ������ ����̳߳����쳣���ᵼ����־�������ȫ
 * ���ü��ϣ����⿪���̣߳���¼��־ʱ��ֻ��Ҫ����־�����������棬������̸߳�����������е����ݡ�
 * @author liang
 *
 */
public class SystemHelp {

//	public static void main(String[] args) throws CharacterCodingException {
//		println("zhangzhiliang");
//		Charset charset = Charset.forName("gbk");
//		CharsetDecoder decoder = charset.newDecoder();
//		
//		
//		ByteBuffer buffer = ByteBuffer.allocate(1024);
//		buffer.put("abcdef".getBytes());
//		buffer.flip();
////		CharBuffer charB = decoder.decode(buffer);
////		System.out.println(charB);
//		buffer.clear();
////		System.out.println(decoder.decode(buffer));
//		buffer.put("12".getBytes());
//		buffer.flip();
////		System.out.println(decoder.decode(buffer));
//		
//		
//		
//	}
	
	public static void println(String str){
		println(str, "java/test/file.txt",true);
	}
	
	public static void println(String str,String fileName){
		println(str, getRalitivePath(fileName), true);
	}
	
	public static void println(String str,String fileName,boolean boo){
		File file = new File(fileName);
		FileOutputStream out = null;
		FileChannel channel = null;
		ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());//������ˡ����buffer�Ĺ��ܣ��������flip�Ĺ��ܡ�
		try{
			out = new FileOutputStream(file,boo);
			channel = out.getChannel();
			
			channel.write(buffer);
			
			buffer.clear();
			
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try {
				if(channel != null){
					channel.close();
				}
				if(out != null){
					out.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void printlnMap(String str){
		println(str + "\r\n",getRalitivePath("digestor-cache.txt"),false);
	}
	
	private static String getRalitivePath(String str){
		return "java/test/" + str; //
	}
	
}
