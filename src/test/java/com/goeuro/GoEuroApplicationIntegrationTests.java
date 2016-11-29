package com.goeuro;

import com.goeuro.domain.Location;
import com.goeuro.location.client.LocationClient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoEuroApplicationIntegrationTests {

	@Autowired
	public LocationClient locationClient;

	@Test
	public void test_GetResponse_success(){
		Assert.assertNotNull(locationClient.getResponse("Kiev"));
	}

	@Test
	public void test_GetResponse_fail(){
		Assert.assertArrayEquals(new Location[0], locationClient.getResponse("UnknownCity"));
	}

	@Test(expected = HttpClientErrorException.class)
	public void test_GetResponse_badPath(){
		Assert.assertNotNull(locationClient.getResponse(""));
	}


}
