package com.vsg.adj.xspeedit;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by adjengue on 30/05/2017.
 */
public class Colis {
    private Collection<Integer> articles;
    private int tailleColis;

    public Colis() {
        articles = new ArrayList<Integer>();
        tailleColis = 0;
    }

    public Collection<Integer> getArticles() {
        return articles;
    }

    public void setArticles(Collection<Integer> articles) {
        this.articles = articles;
    }

    public int getTailleColis() {
        return tailleColis;
    }

    public void setTailleColis(int tailleColis) {
        this.tailleColis = tailleColis;
    }

    public boolean addArticle(int article) {
        if (tailleColis + article > Constants.MAX_SIZE) {
            return false;
        }
        articles.add(article);
        tailleColis += article;

        return true;
    }

    public boolean isFull() {
        if (this.getArticles().isEmpty()) {
            return false;
        } else {
            if (getTailleColis() < Constants.MAX_SIZE) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Colis{" +
                "articles=" + articles +
                ", tailleColis=" + tailleColis +
                '}';
    }
}
