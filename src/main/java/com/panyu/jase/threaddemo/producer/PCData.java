package com.panyu.jase.threaddemo.producer;

public final class PCData {
    private final int intData;

    public PCData(int intData) {
        this.intData = intData;
    }
    public int getData(){
        return intData;
    }

    @Override
    public String toString() {
        return "PCData{" +
                "intData=" + intData +
                '}';
    }
}
