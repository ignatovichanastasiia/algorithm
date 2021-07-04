import java.util.Objects;

public class Model {
    private int num;

    public Model(int i) {
        this.num = i;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "Model{" + num + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Model)) return false;
        Model model = (Model) o;
        return getNum() == model.getNum();
    }
}

