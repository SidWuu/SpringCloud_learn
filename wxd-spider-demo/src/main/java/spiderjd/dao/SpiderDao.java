package spiderjd.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import spiderjd.mapper.SpiderMapper;
import spiderjd.vo.SpiderGoodsInfo;

@Repository
public class SpiderDao {
	private static String DATASOURCE="mybatis-config.xml";
	public static SqlSession getSession(){
		SqlSession session=null;
		try {
			InputStream is=Resources.getResourceAsStream(DATASOURCE);
			SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
			session=factory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return session;
	}
	
	public void saveJd(SpiderGoodsInfo mod){
		SqlSession session=getSession();
		try {
			mod.setDbid(null);
			session.getMapper(SpiderMapper.class).insert(mod);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	
}
