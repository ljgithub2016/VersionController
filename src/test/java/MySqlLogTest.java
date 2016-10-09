import java.util.Date;

import javax.annotation.Resource;

import org.apache.lucene.search.TermQuery;
import org.elasticsearch.common.geo.GeoPoint;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lj.elasticsearch.entities.GeoInfo;
import com.lj.elasticsearch.entities.MySqlLog;
import com.lj.elasticsearch.repositories.GeoInfoRepository;
import com.lj.elasticsearch.repositories.MySqlLogRepository;

import static org.elasticsearch.index.query.QueryBuilders.*;  


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-context-es.xml")
public class MySqlLogTest {


	@Resource
	private ElasticsearchTemplate elasticsearchTemplate;
	 
	@Test
	public void testCount(){
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(termQuery("message", "sys_user")).build();  
		long count = elasticsearchTemplate.count(searchQuery, MySqlLog.class);
		System.out.println(count);
	}
}
