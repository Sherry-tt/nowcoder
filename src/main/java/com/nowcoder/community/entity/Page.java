package com.nowcoder.community.entity;

/**
 * Pagination
 */

public class Page {

    // Current page number
    private int current = 1;
    // Display limit
    private int limit = 10;
    // Total number of data
    private int rows;
    // Query path (link)
    private String path;


    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if(current >= 1) {
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if(limit >= 1 && limit <=100) {
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if(current >= 0) {
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Get the start number of rows
     * @return
     */
    public int getOffset() {
        // current * limit - limit
        return (current-1) * limit;
    }

    /**
     * Get the total number of pages
     * @return
     */
    public int getTotal() {
        // rows / limit
        return rows % limit == 0 ? rows/limit : rows/limit+1;
    }

    /**
     * Get start page number
     * @return
     */
    public int getFrom() {
        int from = current - 2;
        return from < 1 ? 1 : from;
    }

    /**
     * Get end page number
     * @return
     */
    public int getTo() {
        int to = current + 2;
        int total = getTotal();
        return to > total ? total : to;
    }

}
