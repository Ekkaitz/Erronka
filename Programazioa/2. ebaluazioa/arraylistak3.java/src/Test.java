public class Test {
    public static void main(String[] args) {
        Movie m1=new Movie("titanic",400,2001);
        Movie m2=new Movie("Casablanca",100,1939);
        Movie m3=new Movie("El niño con el pijamilla",120,1939);
        Movie m4=new Movie("jurasic park",70,2011);
        Movie m5=new Movie("Programar no es para tanto 2",320,2021);

        Cinema c1=new Cinema("Cines txingudi",6);


        System.out.println(c1.roomOfMovie(m1));

        c1.addMovie(m1);
        c1.addMovie(m2);
        c1.addMovie(m3);
        c1.addMovie(m4);
        c1.addMovie(m5);





    }
}