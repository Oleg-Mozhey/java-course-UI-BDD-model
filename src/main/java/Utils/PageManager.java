package Utils;

public class PageManager {

    public PageManager() {
    }

    private WebPage currentPage;

    public WebPage getCurrentPage() {
        return currentPage.initialize();
    }

    public void setCurrentPage(WebPage webPage) {
        this.currentPage = webPage;
    }

}