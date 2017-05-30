package com.vsg.adj.xspeedit;

import org.junit.Test;

/**
 * Created by adjengue on 30/05/2017.
 */
public class ColisTest {

    @Test
    public void souldGiveSize() {
        Colis c = new Colis();
        c.addArticle(new Integer(1));
        c.addArticle(new Integer(2));
        c.addArticle(new Integer(3));

        assert c != null;
        assert c.getArticles().size() != 0;
        assert c.getArticles().size() == 3;
        assert c.getTailleColis() == 6;
    }

    @Test
    public void shouldNotBeEmpty() {
        Colis c = new Colis();

        c.addArticle(new Integer(1));
        c.addArticle(new Integer(2));
        c.addArticle(new Integer(3));

        assert c != null;
        assert c.getArticles().size() != 0;
        assert c.getArticles().size() == 3;
        assert c.getTailleColis() == 6;
        assert c.isFull() == false;
    }

    @Test
    public void shouldBeEmpty() {
        Colis c = new Colis();

        assert c != null;
        assert c.getArticles().size() == 0;
        assert c.getTailleColis() == 0;
        assert c.isFull() == false;
    }

    @Test
    public void shouldBeFull() {
        Colis c = new Colis();

        c.addArticle(new Integer(5));
        c.addArticle(new Integer(2));
        c.addArticle(new Integer(3));

        assert c != null;
        assert c.getArticles().size() != 0;
        assert c.getArticles().size() == 3;
        assert c.getTailleColis() == 10;
        assert c.isFull() == true;
    }
}
