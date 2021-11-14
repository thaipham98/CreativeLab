public class Driver {
    public static void main(String[] args){
        ICharacter badguy1 = new Enemy("badguy1", 100, 100);

        int aa = badguy1.attack();
        System.out.println(aa);
    }
}
