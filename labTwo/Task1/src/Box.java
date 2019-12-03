public class Box{

    int h,w,d;

  public Box(int h, int w, int d){

      this.h = h;
      this.w = w;
      this.d = d;


  }

    public Box(){

        h = 5;
        w = 5;
        d = 5;
    }

    public Box(int n){

       h = n;
       w = n;
       d = n;
    }
   public void getinfo() {
       System.out.println("Weight - " + h + "\nWidth - " + w + "\nDepth - " + d);
   }
}