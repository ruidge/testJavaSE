package com.ruidge.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestGson1 {
    public static void main(String[] args) {
        String[] descImgList = {"http://img.dmallcdn.com/20180116/66425b3b-e3b9-4d6d-b1ce-2d1fc310ca82_m640",
                "http://img.dmallcdn.com/20180116/49f62951-3ed1-495e-bb01-7c7a6368d11f_m640",
                "http://img.dmallcdn.com/20180116/bf3a35fa-41ad-4efe-83dd-48262d3d918b_m640",
                "http://img.dmallcdn.com/20180116/c0e6ebcc-62b7-42d9-96bb-d1db5d3c8cd8_m640",
                "http://img.dmallcdn.com/20180116/a0e20c36-1143-4e03-a664-697f3fae3840_m640",
                "http://img.dmallcdn.com/20180116/ac88a758-3632-4c9f-8680-0f3ee7b6adf4_m640",
                "http://img.dmallcdn.com/20180116/bf5859da-fa19-4493-8744-6fdedd339d11_m640",
                "http://img.dmallcdn.com/20180116/77146451-2d5e-45ab-a3c1-9eb7d8172e66_m640",
                "http://img.dmallcdn.com//20171122/a9350149-58f3-4220-b64f-de5865908ecd_m640"};


        String[] wareImgList = {
                "http://jzvd.nathen.cn/df6096e7878541cbbea3f7298683fbed/ef76450342914427beafe9368a4e0397-5287d2089db37e62345123a1be272f8b.mp4",
                "http://img.dmallcdn.com/20171211/b9fb9559-df6a-4045-ade9-12d3af8feeea_800x800H.webp",
                "http://img.dmallcdn.com/20171208/a5452b66-e152-4162-ad0b-0ee98ef4fe1a_800x800H.webp",
                "http://img.dmallcdn.com/20171208/6b1aafde-214a-473f-b502-feeec5f05484_800x800H.webp",
                "http://img.dmallcdn.com/20171208/897621b2-6b24-43a8-bd8e-b3c098e39f7f_800x800H.webp",
                "http://img.dmallcdn.com/20171208/af22ea92-7a61-493d-b767-cf536c182558_800x800H.webp",
                "http://img.dmallcdn.com/20171208/e7107027-a35f-4483-848f-81d102e34c9b_800x800H.webp"};
        ArrayList<WareImgVO> list = new ArrayList<>();
        for (String str : descImgList) {
            WareImgVO imgVO = new WareImgVO(1, null, str);
            list.add(imgVO);
        }

        String result = new Gson().toJson(list);
        System.out.println(result);

    }

    static class WareImgVO {
        WareImgVO() {
        }

        WareImgVO(int type, String coverUrl, String url) {
            this.type = type;
            this.coverUrl = coverUrl;
            this.url = url;
        }

        public int type; //1图片 2视频

        public String coverUrl;

        public String url;

        public boolean isVideoType() {
            return type == 2;
        }

    }
}
