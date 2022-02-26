package com.example.ash.numbfacts;


public class RowItem {
    private String desc;

    public RowItem(String desc) {
         this.desc = desc;
    }

       public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    @Override
    public String toString() {
        return desc;
    }
}
