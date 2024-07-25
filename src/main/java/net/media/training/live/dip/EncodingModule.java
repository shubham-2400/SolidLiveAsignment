package net.media.training.live.dip;


import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 13, 2011
 * Time: 10:05:38 AM
 * To change this template use File | Settings | File Templates.
 */


public class EncodingModule implements EncodingModuleInterface {
    public void encodeWithFiles() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/shubham.gho/Downloads/SolidLiveAsignment-master/src/main/java/net/media/training/live/dip/beforeEncryption.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/shubham.gho/Downloads/SolidLiveAsignment-master/src/main/java/net/media/training/live/dip/afterEncryption.txt"));
            String aLine;
            while ((aLine = reader.readLine()) != null) {
                String encodedLine = Base64.getEncoder().encodeToString(aLine.getBytes());
                writer.write(encodedLine);
            }
            writer.flush();
            writer.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String readURLContents(URL url){
        InputStream in = null;
        try {
            in = url.openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStreamReader reader = new InputStreamReader(in);
        StringBuilder inputStringBuilder = new StringBuilder();
        try {
            int c;
            c = reader.read();
            while (c != -1) {
                inputStringBuilder.append((char) c);
                c = reader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String inputString = inputStringBuilder.toString();
        return inputString;
    }

    public void encodeBasedOnNetworkAndDatabase() {
        URL url = null;
        try {
            url = new URL("https", "example.com", "/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        
        String inputString = readURLContents(url);
        String encodedString = Base64.getEncoder().encodeToString(inputString.getBytes());
        MyDatabase database = new MyDatabase();
        database.write(encodedString);
    }
}

