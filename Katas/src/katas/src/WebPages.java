package katas.src;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WebPages {
    private LinkService linkService;

    public WebPages(LinkService linkService) {
        this.linkService = linkService;
    }

    public int getDistanceFrom(String aPage, String otherPage) {
        if(aPage.equalsIgnoreCase(otherPage))
            return 0;
        List<String> links = Arrays.asList(linkService.getLinksFor(aPage));
        if (links.contains(otherPage))
            return 1;
        int distance = 1;
        do {
            List<String> level = new java.util.LinkedList<>();
            for (String link : links) {
                List<String> innerLinks = Arrays.asList(linkService.getLinksFor(link));
                if (innerLinks.contains(otherPage)) {
                    return distance+1;
                }
                level.addAll(innerLinks);
            }
            distance = links.isEmpty() ? distance : distance + 1;
            links = level;
        } while (!links.isEmpty());

        throw new IllegalArgumentException("Page not found");
    }


    public interface LinkService {
        String[] getLinksFor(final String page);
    }
}


