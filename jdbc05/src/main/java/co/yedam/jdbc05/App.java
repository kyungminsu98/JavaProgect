package co.yedam.jdbc05;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Hello world!
 *
 */
public class App{ 
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
//        EmpVO evo = new EmpVO();
//        evo.setEmpId(100);
//        evo.getEmpId();
    	String resource = "mybatis-config.xml";
    	InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	SqlSessionFactory sqlSessionFactory = //
    			new SqlSessionFactoryBuilder().build(inputStream);
    	//
    	SqlSession session = sqlSessionFactory.openSession(true);
//    	List<EmpVO> list = session.selectList("co.yedam.jdbc05.QueryMapper.selectEmp");
//    	for(EmpVO vo : list) {
//    		System.out.println(vo.toString());
//    	}
        EmpVO evo = new EmpVO();
        evo.setEmployeeId(555);
        evo.setEmail("555@email.com");
        evo.setLastName("Park");
        evo.setHireDate(new Date());
        evo.setJobId("IT_PROG");
        evo.setSalary(200);
        evo.setFirstName("hee");
        
        int r = session.update("co.yedam.jdbc05.QueryMapper.updateEmp", evo);
        System.out.println(r + "건 업데이트 되었습니다.");
        
        EmpVO vo = session.selectOne("co.yedam.jdbc05.QueryMapper.getEmp", 555);
        System.out.println(vo.toString());


    }
}