package com.ssm.domain;

public enum ColorEnum {
    K("快递送样"){
        public void  haha(){
            System.out.println("快递");
        }
    },
    Y("用户送样"){
        public void  haha(){
            System.out.println("用户");
        }
    };

    private String itemValue;
    private String itemLabel;

    ColorEnum(String itemLabel){
        this.itemValue = this.name();
        this.itemLabel = itemLabel;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }

    public String getItemLabel() {
        return itemLabel;
    }

    public void setItemLabel(String itemLabel) {
        this.itemLabel = itemLabel;
    }
}
