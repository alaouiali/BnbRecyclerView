package in.alaoui.horizontalinsideverticalrecyclerview.models;

public class ParentItem {
    String text;
    int position;

    public ParentItem(String text) {
        this.text = text;
        this.position = 0;
    }

    public String getText() {
        return text;
    }

    public int getPosition() {
        return position;
    }
    public void setPosition(int pos) {
        this.position = pos;
    }
}