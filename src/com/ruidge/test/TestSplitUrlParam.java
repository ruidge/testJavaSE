package com.ruidge.test;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class TestSplitUrlParam {

    //    static String url = "http://atlas.dmall.com/report/track/atlas_app_click?log=7EBF4E3B87025DF3CD17E66518E3E1820619290B390D1D8001DAA8ABAA391CA770F96F7EA39C0BFE1A4D613DD620F990C357C2BF6913687FDB47FC0FC42B55303172F0FDBFF4FE40FABE34FC8D686C28A98E682265F04857339C34EFC818C8A562C6F6E8DF5568C4C008ABC2E2047C6E5F41B6C859BC3372C9DFF973B87A2E53CE81F04E94F010E1A2CB9C0EC5223C2F9DDDB3BCB6C5CC8D180AE84127997DAD536FF13CBB1A69647A70FF48CF12C840A339C38B6389FB0F9D6417BFAD0BB9CE6DA9553B52F61D4B858D7489955DFDD11C799D7CD9E8A7560AD4660FFE84A98BC029C896C208E7AFDE538D68B138FAFB5B1111926EB3A87A184ED79B2C37251F1DBD1F1C4F788B94DE7061E01C74990CDD65D6B4B8542C52F15C80915C0AFDAEB35697F7E5B8F879A97D0A545571228C&param={\"sysSource\":\"search\"}";
    static String url = "http://atlas.dmall.com/report/track/atlas_app_click?log=7EBF4E3B87025DF3CD17E66518E3E1820619290B390D1D8001DAA8ABAA391CA770F96F7EA39C0BFE1A4D613DD620F990C357C2BF6913687FDB47FC0FC42B55303172F0FDBFF4FE40FABE34FC8D686C28A98E682265F04857339C34EFC818C8A562C6F6E8DF5568C4C008ABC2E2047C6E5F41B6C859BC3372C9DFF973B87A2E53CE81F04E94F010E1A2CB9C0EC5223C2F9DDDB3BCB6C5CC8D180AE84127997DAD536FF13CBB1A69647A70FF48CF12C840A339C38B6389FB0F9D6417BFAD0BB9CE6DA9553B52F61D4B858D7489955DFDD11C799D7CD9E8A7560AD4660FFE84A98BC029C896C208E7AFDE538D68B138FAFB5B1111926EB3A87A184ED79B2C37251F1DBD1F1C4F788B94DE7061E01C74990CDD65D6B4B8542C52F15C80915C0AFDAEB35697F7E5B8F879A97D0A545571228C&param=%7B%22sysSource%22%3A%22search%22%7D";
//    static String url = "http://atlas.dmall.com/report/track/atlas_app_click?param=ss={\"sysSource\":\"search\"}";

    public static void main(String[] args) {
        System.out.println(url);
        System.out.println(encodeUri(url));

    }

    public static String encodeUri(String url) {
        String result = url;
        if (url.contains("?")) {
            String[] strings = url.split("\\?");
            if (strings.length == 2) {
                String before = strings[0];
                String after = strings[1];
                if (after.contains("&")) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String[] sQuery = after.split("&");
                    for (String q : sQuery) {
                        String[] ss = q.split("=");
                        if (ss.length == 2) {
                            String key = ss[0];
                            String value = ss[1];
                            String decodeStr = URLDecoder.decode(value);
                            value = URLEncoder.encode(decodeStr);
                            if (stringBuilder.length() > 0) {
                                stringBuilder.append("&");
                            }
                            stringBuilder.append(key + "=" + value);
                        }
                    }
                    result = before + "?" + stringBuilder.toString();
                } else {
                    if (after.contains("=")) {
                        String[] ss = after.split("\\=");
                        if (ss.length == 2) {
                            String key = ss[0];
                            String value = ss[1];
                            String decodeStr = URLDecoder.decode(value);
                            value = URLEncoder.encode(decodeStr);
                            result = before + "?" + key + "=" + value;
                        }
                    } else {
                        result = before + "?" + after;
                    }
                }
            }
        }
        return result;
    }

}
