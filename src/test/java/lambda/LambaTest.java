package lambda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import org.junit.Test;

public class LambaTest {

	
	@Test
	public void hello(){
		HelloService hs = ()->System.out.println(123); //使用lambda 定义一个函数接口 HelloService
		hs.sayHello();
	}
	
	
	@Test
	public void play(){
		List<String> games = new ArrayList<String>();
		games.add("1");
		games.add("2");
		games.add("3");
		games.add("4");
		games.forEach(game->System.out.println("game is : " + game));
		
	}
	
	@Test
	public void readFunction2(){
		File file = new File("D:\\用户目录\\我的文档\\Tencent Files\\423700542\\FileRecv\\log.txt"); 
		try(BufferedReader reader = new BufferedReader(new FileReader(file))){
			Stream<String> streams = reader.lines();
			streams.forEach(line-> {
				//Predicate. 
			});
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
	
	@Test
	public void read0(){
		File file = new File("D:\\用户目录\\我的文档\\Tencent Files\\423700542\\FileRecv\\log.txt"); 
		try(BufferedReader reader = new BufferedReader(new FileReader(file))){
			Stream<String> streams = reader.lines();
			streams.forEach(line-> System.out.println(line));
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void readException1(){
		int max = 10;
		File file = new File("D:\\用户目录\\我的文档\\Tencent Files\\423700542\\FileRecv\\log.txt"); 
		try(BufferedReader reader = new BufferedReader(new FileReader(file))){
			Stream<String> streams = reader.lines();
			streams.forEach(line->{
				System.out.println(line);
				if(SimleInt.jiajia() == max){
					throw new RuntimeException("max is 10");
				}
				}
			);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	static class SimleInt{
		private static int count = 0;
		
		public static  int jiajia(){
			return count++;
		}
	}
	
	
}
