package com.example.novel.mode;

public class AllCategoryModel {
    Integer id;
    Integer imageurl;
    public AllCategoryModel(Integer id, Integer imageurl) {
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
