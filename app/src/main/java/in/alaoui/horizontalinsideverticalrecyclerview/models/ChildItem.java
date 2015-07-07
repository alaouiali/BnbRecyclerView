package in.alaoui.horizontalinsideverticalrecyclerview.models;

public class ChildItem {
    String text;
    String url;

    public ChildItem(String text, String url) {
        this.text = text;
        this.url = url;
    }

    public String getText() {
        return text;
    }
    public String getUrl(){
        return url;
    }
}