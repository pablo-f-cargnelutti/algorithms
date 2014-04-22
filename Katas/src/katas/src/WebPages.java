package katas.src;

import java.util.Arrays;
import java.util.List;

public class WebPages {
    private LinkService linkService;

    public WebPages(LinkService linkService) {
        this.linkService = linkService;
    }

    public int getDistanceFrom(String aPage, String otherPage) {
        if(aPage.equalsIgnoreCase(otherPage))
            return 0;
        java.util.Queue<String> queue = new java.util.LinkedList<>();
        queue.offer(aPage);
        int distance = 1;
        do {
            List<String> links = Arrays.asList(linkService.getLinksFor(queue.poll()));
            if (links.contains(otherPage))
                return distance;

            for (String link : links) {
                List<String> innerLinks = Arrays.asList(linkService.getLinksFor(link));
                if (innerLinks.contains(otherPage)) {
                    return distance;
                }
            }
            distance = links.isEmpty() ? distance : distance + 1;
            queue.addAll(links);
        } while ( !queue.isEmpty() );

        throw new IllegalArgumentException("Page not found");
    }


    public interface LinkService {
        String[] getLinksFor(final String page);
    }
}


