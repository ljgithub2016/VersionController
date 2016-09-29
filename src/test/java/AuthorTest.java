import java.util.Date;

import javax.annotation.Resource;

import org.elasticsearch.common.geo.GeoPoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lj.elasticsearch.entities.GeoInfo;
import com.lj.elasticsearch.repositories.AuthorRepository;
import com.lj.elasticsearch.repositories.GeoInfoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-context-es.xml")
public class AuthorTest {

	@Resource
	private AuthorRepository authorRepository;
	
	@Test
	public void testSave(){
		
	}
}
