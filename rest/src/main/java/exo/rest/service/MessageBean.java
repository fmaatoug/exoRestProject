package exo.rest.service;

import java.util.List;

public class MessageBean {
  private List<Object> data;
  
  public void setData(List<Object> list) {
    this.data = list;
  }
  public List<Object> getData() {
    return data;
  }
 
}