package com.example.novel.mode;

import java.io.Serializable;

public class DiscountedProducts implements Serializable {

    Integer id;
    Integer imageurl;
    public DiscountedProducts(Integer id,Integer imageurl) {
        this.id = id;
        this.imageurl = imageurl;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getImageurl() {
        return imageurl;
    }

    public void setImageurl(Integer imageurl) {
        this.imageurl = imageurl;
    }

    @Override
    public String toString() {
        return "DiscountedProducts{" +
                "id=" + id +
                ", imageurl='" + imageurl + '\'' +
                '}';
    }
}
