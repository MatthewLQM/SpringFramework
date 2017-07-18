package com.matthew.common.argument;

import java.util.List;

public class AutoGeneratorArguments {
    private String originString;
    private List<Integer> begin;
    private List<Integer> end;
    public void setOriginString(String originString){
        this.originString = originString;
    }
    public String getOriginString(){
        return this.originString;
    }
    public void setBegin(List<Integer> begin){
        this.begin = begin;
    }
    public List<Integer> getBegin(){
        return this.begin;
    }
    public void setEnd(List<Integer> end){
        this.end = end;
    }
    public List<Integer> getEnd(){
        return this.end;
    }
}
