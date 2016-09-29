import java.io.FileInputStream;
import java.util.Date;

import javax.annotation.Resource;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lj.gps.enties.GpsEntity;
import com.lj.gps.repositories.GpsRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-context-es.xml")
public class GpsTest {

	@Resource
	private GpsRepository gpsRepository;
	
	@Resource
	private ElasticsearchTemplate elasticsearchTemplate;
	 
	@Test
	public void testSave(){
		GpsEntity info = new GpsEntity();
		info.setId(String.valueOf(System.currentTimeMillis()));
		info.setVersion(1L);
		info.setCreateDate(new Date());
		info.setGeoPoint(new GeoPoint(39.1111, 117.246));
		gpsRepository.save(info);
	}
}
