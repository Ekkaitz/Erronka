public class Bird {
    char sex;
    int age;
    static int numberOfBirds;

    Bird(char a, int b){
        this.age=b;
        this.sex=a;
        numberOfBirds++;
    }

    public static int getNumberOfBirds() {
        return numberOfBirds;
    }

    public void whoAmI(){
        System.out.print("sex "+sex+" ");
        System.out.println("age "+age);
    }
}
