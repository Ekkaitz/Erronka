public class Pints implements Comparable<Pints>{
    private int x;
    private int y;

    Pints(int a,int b){
        this.x=a;
        this.y=b;
    }

    Pints(){
        this.x=0;
        this.y=0;
    }

    public String toString(){
        return ""+x+y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    @Override
    public int compareTo(Pints o) {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}


