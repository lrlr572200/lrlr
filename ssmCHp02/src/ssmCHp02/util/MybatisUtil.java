package ssmCHp02.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
		private static SqlSessionFactory fact=null;
		 //¾²Ì¬´úÂë¿é
		static {
			InputStream is;
			try {
				is = Resources.getResourceAsStream("mybatis_config.xml");
				fact=new SqlSessionFactoryBuilder().build(is);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//static
		
		public static SqlSessionFactory getSqlSessionFactory()
		{
			return fact;
		}
}
