package pl.coderslab.jenkinsJobBuild;

import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

@Service
public class JobBuild {

    public String deployApp(String serverIP, String warName) {
        try {
            URL url = new URL ("http://107.23.92.224:8080/job/aws-deploy/buildWithParameters");
            String user = "ewe123";

            Properties prop = new Properties();
            String propFileName = "config.properties";
            InputStream inputStream = null;

            inputStream = JobBuild.class.getClassLoader().getResourceAsStream(propFileName);

            if(inputStream==null){
                System.out.println("Sorry, unable to find " + propFileName);

            }
            prop.load(inputStream);

            String appVersion = prop.getProperty("password");
//            System.out.println(prop.getProperty("password"));

            String pass = appVersion;
            String authStr = user +":"+  pass;
            String encoding = DatatypeConverter.printBase64Binary(authStr.getBytes("utf-8"));

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoding);

//            String urlParams="ServerIP=54.164.84.221&WarName=test.war";
            String urlParams= "ServerIP="+serverIP+"&WarName="+warName;

            byte[] postData = urlParams.getBytes("utf-8");
            try(DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                wr.write(postData);
            }

            InputStream content = connection.getInputStream();
            BufferedReader in   =
                    new BufferedReader (new InputStreamReader(content));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return "0";
    }

}
