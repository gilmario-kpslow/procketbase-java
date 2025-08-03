/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pocketbase.service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gilmario
 * @param <M>
 */
public class ResultList<M> {

    private Integer page;
    private Integer perPage;
    private Integer totalItems;
    private Integer totalPages;
    private List<M> items;

    public ResultList() {
    }

    public ResultList(Integer page, Integer perPage, Integer totalItems, Integer totalPages) {
        this.page = page;
        this.perPage = perPage;
        this.totalItems = totalItems;
        this.totalPages = totalPages;
        items = new ArrayList<>();
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

    public List<M> getItems() {
        return items;
    }

    public void setItems(List<M> items) {
        this.items = items;
    }

}
