import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lj.elasticsearch.entities.MySqlLog;

import static org.elasticsearch.index.query.QueryBuilders.*;  


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-context-es.xml")
public class MySqlLogTest {


	@Resource
	private ElasticsearchTemplate elasticsearchTemplate;
	
	static int tablebakcount = 0;
	
	@Test
	public void testCount(){
		File file = new File("F:\\Files\\tables.txt"); //保存所有表名的的文件
		Map<String,Long> tablecountMap = new TreeMap<String,Long>();
		Map<String,Long> tableZeroCountMap = new TreeMap<String,Long>();
		List<String> dropTables = new ArrayList<String>();
		try(BufferedReader reader = new BufferedReader(new FileReader(file))){
			
			this.query(reader, tablecountMap, tableZeroCountMap);
			
			this.genResult(tablecountMap, tableZeroCountMap, dropTables);
			
		}catch(Exception e){
			e.printStackTrace();
		} 
	}
	
	private void query(BufferedReader reader, Map<String,Long> tablecountMap,  Map<String,Long> tableZeroCountMap) throws IOException{
		String tablename = null;
		while((tablename = reader.readLine()) != null){
			SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(termQuery("message", tablename)).build();  
			long count = elasticsearchTemplate.count(searchQuery, MySqlLog.class);
			System.out.println(count);
			tablecountMap.put(tablename, count);
			if(count < 1){
				tableZeroCountMap.put(tablename, count);
			}
		}
	}
	
	
	private void genResult(Map<String,Long> tablecountMap, Map<String,Long> tableZeroCountMap, List<String> dropTables){
		File file2 = new File("F:\\Files\\tables_result.txt"); //结果输出文件
		try(FileWriter writer = new FileWriter(file2)){
			
			writer.write("============all table count info["+tablecountMap.keySet().size()+"]: \r\n");
			this.write(tablecountMap,null,  writer, false);
			
			writer.write("============zero count table  info["+tableZeroCountMap.keySet().size()+"]: \r\n");
			this.write(tableZeroCountMap, dropTables, writer, true);
			
			writer.write("============drop zero count table  info["+ dropTables.size()+"], includ bak table["+tablebakcount+"]: \r\n");
			for(String item : dropTables){
				writer.write(item);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void write(Map<String,Long> map, List<String> dropTables, FileWriter writer, boolean genDropInfo) throws Exception{
		Iterator iterator = map.keySet().iterator();
		while(iterator.hasNext()){
			String tablename = iterator.next().toString();
			writer.write(tablename + "\t" + map.get(tablename) + "\r\n");
			if(genDropInfo){
				if(isCanDrop(tablename)){
					String dropSql = "drop table if exists " + tablename + "; \r\n";
					dropTables.add(dropSql);
				}
			}
		}
	}
	
	private boolean isCanDrop(String tableName){
		boolean canDrop = false;
		if("car_brand".equals(tableName)){
			canDrop = true;
		}else if (tableName.contains("bak")){
			tablebakcount ++;
			canDrop = true;
		}else if(tableName.startsWith("pur_")){
			canDrop = true;
		}
		return canDrop;
	}
}
