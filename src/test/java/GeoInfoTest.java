import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.elasticsearch.common.geo.GeoPoint;
import org.elasticsearch.common.geo.GeoUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lj.elasticsearch.entities.GeoInfo;
import com.lj.elasticsearch.repositories.GeoInfoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-context-es.xml")
public class GeoInfoTest {

	@Resource
	private GeoInfoRepository geoInfoRepository;
	@Resource
	private ElasticsearchTemplate elasticsearchTemplate;
	 
	@Test
	public void testSave(){
		GeoInfo info = new GeoInfo();
		info.setId("1");
		info.setName("liujia");
		info.setLocation("22.6049,113.8423");//lat,lon
		info.setCreateDate(new Date());
		info.setCity("深圳市");
		info.setAddress("广东省深圳市宝安区工业路");
		geoInfoRepository.save(info);
	}
	
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
	
	@Test
	public void testSaveFromFile(){
		String path ="G:\\geo\\111111.csv";
		try(FileReader reader = new FileReader(path)){
			BufferedReader buffer = new BufferedReader(reader);
			String line = null;
			List<GeoInfo> list = new ArrayList<GeoInfo>();
			int count = 0;
			while((line=buffer.readLine()) != null){
				System.out.println(count+"\t:" + line);
				count++;
				String[] array = line.split(",");
				GeoInfo info = new GeoInfo();
				info.setId(String.valueOf(System.currentTimeMillis()));
				info.setName("测试");
				info.setLocation(array[0]+","+array[1]);
				info.setCreateDate(format.parse(array[2]));
				info.setCity(array[3]);
				info.setAddress(array[4]);
				geoInfoRepository.save(info);
				System.out.println("处理: " + count + ", "+line);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void reBuildIndex(){
		boolean success = elasticsearchTemplate.deleteIndex(GeoInfo.class);
		if(success){
			elasticsearchTemplate.createIndex(GeoInfo.class);
		}
	}
	
	@Test
	public void deleteIndex(){
		boolean success = elasticsearchTemplate.deleteIndex(GeoInfo.class);
		System.out.println(success);
	}
	
	@Test
	public void createIndex(){
		elasticsearchTemplate.createIndex(GeoInfo.class);
	}
}
