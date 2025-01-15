package tests.api;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class HttpClientTest {

    @Test
    public void simpleTest() throws IOException {
        String baseUrl = "https://webgroupdan123.testrail.io" ;


        HttpUriRequest request = new HttpGet(baseUrl);

        HttpResponse response = HttpClientBuilder
                .create()
                .build()
                .execute(request);

        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }
}
