package QAQ1;

public abstract class Dd {
    Integer d = 99;
    void show(){
        System.out.println(this.d);
    }
}

class Ff extends Dd{
    Integer d = 88;
    @Override
    void show() {
        super.show();
    }
}
class Main2{
    public static void main(String[] args) {
        Dd df = new Ff();

        df.show();
    }
}