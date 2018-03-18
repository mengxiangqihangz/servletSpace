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
 * 既然开启io很占资源，那么 一直开启io对服务的影响如何
 * 做缓存 如果线程出现异常，会导致日志输出不完全
 * 利用集合，另外开辟线程，记录日志时，只需要将日志丢到集合里面，另外的线程负责输出集合中的内容。
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
		ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());//既完成了。填充buffer的功能，又完成了flip的功能。
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
