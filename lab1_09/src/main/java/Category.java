public class Category {
    private String name;
    private String comment;
    private String img;

    public Category(String name) {
        this.name = name.toUpperCase();
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

    public String getImg() {
        return img;
    }
}
