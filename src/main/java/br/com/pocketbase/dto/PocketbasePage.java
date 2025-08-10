package br.com.pocketbase.dto;

import java.util.List;

/**
 *
 * @author gilmario
 * @param <T>
 */
public class PocketbasePage<T> {

    private Integer page;
    private Integer perPage;
    private Integer totalItems;
    private Integer totalPages;
    private List<T> items;

    public PocketbasePage() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

}
