package com.ruidge.pattern;

/**
 * Created by lenovo on 2017/2/22.
 */
public class BuilderPattern {

    public static void main(String[] args) {
        AlertDialog dialog = new AlertDialog.Builder().setTitle("title").setSubContent("subContent").setContent("content").create();
        dialog.show();
    }
}

class AlertDialog {

    private String title = "";
    private String content = "";
    private String subContent = "";


    private AlertDialog(Builder builder) {
        title = builder.getTitle();
        content = builder.getContent();
        subContent = builder.getSubContent();
    }

    public void show() {
        System.out.println("show(): " + this);
    }

    @Override
    public String toString() {
        return "AlertDialog{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", subContent='" + subContent + '\'' +
                '}';
    }

    public static class Builder {
        private String title = "";
        private String content = "";
        private String subContent = "";

        public Builder() {
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        public Builder setSubContent(String subContent) {
            this.subContent = subContent;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getSubContent() {
            return subContent;
        }

        public AlertDialog create() {
            return new AlertDialog(this);
        }
    }

}
