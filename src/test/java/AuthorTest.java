import java.util.Date;

import javax.annotation.Resource;

import org.elasticsearch.common.geo.GeoPoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lj.elasticsearch.entities.GeoInfo;
import com.lj.elasticsearch.repositories.GeoInfoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-context-es.xml")
public class AuthorTest {

	@Resource
	private GeoInfoRepository geoInfoRepository;
	
	@Test
	public void testSave(){
		GeoInfo info = new GeoInfo();
		info.setId("1");
		info.setVersion(1L);
		info.setCreateDate(new Date());
		GeoPoint geoInfo = new GeoPoint(22.6049, 113.8423);
		info.setGeopoint(geoInfo);
		geoInfoRepository.save(info);
	}
}
