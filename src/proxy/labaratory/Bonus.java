package proxy.labaratory;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

import java.util.ArrayList;

interface WebPageI{
    void loadPage(String url);
}
class WebPage implements WebPageI{
    @Override
    public void loadPage(String url) {
        System.out.println("loading page");
    }
}
class WebPageProxy implements WebPageI{
    private WebPage webPage = new WebPage();
    private ArrayList<String> blockedURL = new ArrayList<>();

    @Override
    public void loadPage(String url) {
        if(this.blockedURL.contains(url)) {
            throw new ValueException(url + " is blocked");
        }
        this.webPage.loadPage(url);
    }
}