package katas.src;

import java.util.*;
import java.util.LinkedList;

public class WebPages {
    private LinkService linkService;

    public WebPages(LinkService linkService) {
        this.linkService = linkService;
    }

    public int getDistanceFrom(String aPage, String otherPage) {
        if(aPage.equalsIgnoreCase(otherPage)) {
            return 0;
        }

        List<String> links = new LinkedList<>();
        List<String> level = new LinkedList<>();
        level.add(aPage);
        int distance = 0;
        while ( !level.isEmpty() ) {
            distance = level.isEmpty() ? distance : distance + 1;
            for (String page : level) {
                links.addAll(Arrays.asList(linkService.getLinksFor(page)));
                if (links.contains(otherPage)) {
                    return distance;
                }
            }

            level.clear();
            level.addAll(links);
            links.clear();
        }

        throw new IllegalArgumentException("Page not found");
    }

    public interface LinkService {
        String[] getLinksFor(final String page);
    }
}


