package Objects;

public class Employe {
    public String name;
    public String firstname;
    public int salary;
    public String post;

    public Employe(String name_, String firstname_) {
        this.name = name_;
        this.firstname = firstname_;
        this.post = "Vide";
    }

    public void setPost(String post_) {
        this.post = post_;
    }
    public String getPost() {
        return this.post;
    }
}
