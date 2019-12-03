public class Main {

    public static void main(String[] args) {


		Box theBoxOne = new Box();
		System.out.println("\nBox_1 measures:");
		theBoxOne.getinfo();

	 Box theBoxTwo = new Box(12);
        System.out.println("\nBox_2 measures:");
        theBoxTwo.getinfo();

		Box theBoxThree = new Box(3,22,82);
		System.out.println("\nBox_3 measures:");
		theBoxThree.getinfo();


    }
}


