package hw_72;

/**
 Test constructors for SkyView problem
 from CoBo's 2013 exam.
 */

public class UserOfSkyView {

    public static void main(String[] commandLine) {
        System.out.println();

        double[] fromTelescope =
                {0.3, 0.7, 0.8, 0.4, 1.4, 1.1, 0.2, 0.5, 0.1, 1.6, 0.6, 0.9};

        // test the constructor that uses CoBo's signature
        SkyView sv = new SkyView( 4, 3, fromTelescope);
        System.out.println(sv);
        System.out.println();

        // test the other constructor, that omits
        // @numCols from the signature
        sv = new SkyView( 4, fromTelescope);
        System.out.println( sv);
        System.out.println();

        // optional: test getAverage if time permits
        System.out.println( sv.getAverage(1, 2, 0, 1)
                + " ...expecting 0.8"
        );
    }
}
