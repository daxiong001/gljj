package test;

import org.apache.commons.io.FileUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;



/**
 * 带参数的get方法
 */
public class Demo2 {
    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            URI uri = new URIBuilder("http://www.baidu.com/s").setParameter("wd", "java").build();
            HttpGet httpGet = new HttpGet(uri);
            CloseableHttpResponse response = null;
            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200){
                String content = EntityUtils.toString(response.getEntity(), "utf-8");
                FileUtils.writeStringToFile(new File("D:\\gljj\\parsebaidu.html"),content,"utf-8");
                System.out.println("内容长度：" + content.length());
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
