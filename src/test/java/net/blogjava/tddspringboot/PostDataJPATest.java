package net.blogjava.tddspringboot;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostDataJPATest {
	
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private DataSource dataSource;
	
	@Test
	public void test() throws SQLException {
		String productName = dataSource.getConnection().getMetaData().getDatabaseProductName();
		assertThat( productName ).isEqualTo("H2");
	}

}
