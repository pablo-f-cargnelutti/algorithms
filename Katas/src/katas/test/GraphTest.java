package katas.test;

import katas.src.WebPages;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by pcargnel on 4/21/2014.
 */
public class GraphTest {

    private static WebPages pages;

    @BeforeClass
    public static void setup(){
        WebPages.LinkService linkService = new WebPages.LinkService() {
            @Override
            public String[] getLinksFor(String page) {
                if(page.equalsIgnoreCase("page1"))
                    return new String[]{"page2", "page3", "page12"};
                else if(page.equalsIgnoreCase("page2"))
                    return new String[]{"page4", "page13"};
                else if(page.equalsIgnoreCase("page4"))
                    return new String[]{"page5", "page15"};
                else if(page.equalsIgnoreCase("page5"))
                    return new String[]{"page9", "page75"};
                else if(page.equalsIgnoreCase("page3"))
                    return new String[]{"page93", "page35"};
                else if(page.equalsIgnoreCase("page13"))
                    return new String[]{"page93", "page39"};
                return new String[]{};
            }
        };
        pages = new WebPages(linkService);

    }

    @Test
    public void distanceTest1() {
        int distance = pages.getDistanceFrom("page1", "page3");
        assertEquals(1, distance);
    }

    @Test
    public void distanceTest1_2() {
        int distance = pages.getDistanceFrom("page1", "page12");
        assertEquals(1, distance);
    }

    @Test
    public void distanceTest0() {
        int distance = pages.getDistanceFrom("page1", "page1");
        assertEquals(0, distance);
    }

    @Test
    public void distanceTest2() {
        int distance = pages.getDistanceFrom("page1", "page35");
        assertEquals(2, distance);
    }

    @Test
    public void distanceTest3() {
        int distance = pages.getDistanceFrom("page1", "page39");
        assertEquals(3, distance);
    }

    @Test
    public void distanceTest4() {
        int distance = pages.getDistanceFrom("page1", "page9");
        assertEquals(4, distance);
    }

    @Test(expected = IllegalArgumentException.class)
    public void distanceTestUnknownPage() {
        int distance = pages.getDistanceFrom("page1", "pagexxx");
    }
}
