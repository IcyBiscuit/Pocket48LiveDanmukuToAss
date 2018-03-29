package com.live48.bilibili;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.Map;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.*;

public class PostToBilibili {

    public String DoPost(String url, Map<String, String> map, String charset) {

        CloseableHttpClient httpClients = null;
        HttpPost httpPost = null;

        String result = null;

        try {

            httpClients = HttpClients.createDefault();
            httpPost = new HttpPost(url);
            List<NameValuePair> list = new ArrayList<>();
            Iterator iterator = map.entrySet().iterator();

            while (iterator.hasNext()) {

                Entry<String, String> elements = (Entry<String, String>) iterator.next();
                list.add(new BasicNameValuePair(elements.getKey(), elements.getValue()));

            }

            if (list.size() > 0) {

                UrlEncodedFormEntity entityToPost = new UrlEncodedFormEntity(list, charset);
                httpPost.setEntity(entityToPost);

            }

            HttpResponse response = httpClients.execute(httpPost);

            if (response != null) {

                HttpEntity resEntity = response.getEntity();

                if (resEntity != null) {

                    result = EntityUtils.toString(resEntity, charset);
                }
            }
//            return result;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return result;

    }
}
