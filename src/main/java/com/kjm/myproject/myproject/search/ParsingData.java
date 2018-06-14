package com.kjm.myproject.myproject.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;

class ParsingData{
    String url;
    HashMap<String,String> map;
    public ParsingData(String url,HashMap<String,String> map){
        this.url = url;
        this.map = map;
    }

    public String openData(){
        HttpURLConnection conn = null;
        String result;
        try{    
            StringBuilder sb = new StringBuilder();
            Iterator<String> key = map.keySet().iterator();
            
            while(key.hasNext()){
                String mapkey = key.next();
                sb.append(mapkey).append("=").append(map.get(mapkey)).append("&");
            }
            String param = sb.toString();
            
            param = param.substring(0, param.length()-1);
            System.out.println(param);
            url = url+"?"+param;
            System.out.println(url);
            URL urlopen = new URL(this.url);
            conn = (HttpURLConnection)urlopen.openConnection();
            
            BufferedReader bis = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            String line="";
            StringBuilder sb2 = new StringBuilder();
            
            while((line=bis.readLine())!=null){
                sb2.append(line);
            }
            bis.close();
            result = sb2.toString();
        }catch(MalformedURLException ex){
            return "";   
        }catch(IOException ex){
            return "";
        }
        return result;
    }
}