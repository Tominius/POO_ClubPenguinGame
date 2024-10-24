public class Meta extends Casillas{
    private int x;
    private int y;


    public Meta(int x, int y,boolean estado){
        this.x = x;
        this.y = y;
        this.estado = estado;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
