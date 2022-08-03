package com.example.community.entity;

import org.springframework.stereotype.Service;

@Service
public class Page {
    private int current = 1;
    private int limit = 10;
    private int rows;
    // reuse page links
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if (current >= 1) {
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit >= 1 && limit <= 100) {
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if (rows >= 0) {
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
     * get the start row of the current page
     *
     * @return offset
     */
    public int getOffset() {
        return (current - 1) * limit;
    }

    /**
     * get the total pages
     *
     * @return total pages
     */
    public int getTotal() {
        if (rows % limit == 0) {
            return rows / limit;
        } else {
            return rows / limit + 1;
        }
    }

    /**
     * get the first page
     *
     * @return first page
     */
    public int getFrom() {
        int from = current - 2;
        return Math.max(from, 1);
    }

    /**
     * get the last page
     *
     * @return last page
     */
    public int getTo() {
        int to = current + 2;
        int total = getTotal();
        return Math.min(to, total);
    }
}
