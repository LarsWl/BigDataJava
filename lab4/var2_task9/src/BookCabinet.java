public class BookCabinet extends Cabinet implements Furniture{

    public BookCabinet(int height, int width, int length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }
    @Override
    public void setUp() {
        System.out.printf("Set up book cabinet with size: %s x %s x %s\n", height, width, length);
    }
}
