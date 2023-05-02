public class Tweety extends Canary {
    int numberofm;

    Tweety(char a,int b, double c,int d){
        super(a,b,c);
        this.numberofm=d;
    }


    public static void main(String[] args) {

        Tweety tw=new Tweety('M',2,17.2,9);

        Parrot pt=new Parrot('F',3,'N',"gorria");

        pt.whoAmI();
        pt.whereAreYouFrom();

        tw.whoAmI();
        tw.setSize(17.2);
        tw.height();

        System.out.println(numberOfBirds);


    }

}
