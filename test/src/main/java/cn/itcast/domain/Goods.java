package cn.itcast.domain;

public class Goods {
    private Integer id;
    private String name;
    private Double price;
    private String data;
    private String img;
    private String says;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSays() {
        return says;
    }

    public void setSays(String says) {
        this.says = says;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", data='" + data + '\'' +
                ", img='" + img + '\'' +
                ", says='" + says + '\'' +
                '}';
    }
}
