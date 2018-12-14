package com.abdifatahm.m_polisi;

public class Item {

    String etname,etdate,etevent,etlocation,etwitness;

    public Item (String etname,String etdate,String etevent,String etlocation, String etwitness)
    {
        this.etname= etname;
        this.etdate= etdate;
        this.etevent= etevent;
        this.etlocation=etlocation;
        this.etwitness=etwitness;
    }

    public Item(){

    }

    public String getEtname() {
        return etname;
    }

    public void setEtname(String etname) {
        this.etname = etname;
    }

    public String getEtdate() {
        return etdate;
    }

    public void setEtdate(String etdate) {
        this.etdate = etdate;
    }

    public String getEtevent() {
        return etevent;
    }

    public void setEtevent(String etevent) {
        this.etevent = etevent;
    }

    public String getEtlocation() {
        return etlocation;
    }

    public void setEtlocation(String etlocation) {
        this.etlocation = etlocation;
    }

    public String getEtwitness() {
        return etwitness;
    }

    public void setEtwitness(String etwitness) {
        this.etwitness = etwitness;
    }
}
