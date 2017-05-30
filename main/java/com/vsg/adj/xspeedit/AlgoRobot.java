package com.vsg.adj.xspeedit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by adjengue on 30/05/2017.
 */
public class AlgoRobot {

    /*
    * Description : Convertit la chaine d'entiers en liste d'entiers
    *
    * @param in Chaine d'entiers en entrée
    * @return numbers Liste d'entiers
    */
    public List<Integer> convertToInteger(String in) {
        List<Integer> numbers = new ArrayList<>();

        Comparator<Integer> comparatorAsc = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };

        Comparator<Integer> comparatorDsc = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };

        if (in != null && !"".equals(in)) {
            try {
                numbers = Stream.of(in.split(""))
                        .map(d -> Integer.parseInt(d))
                        .filter(d -> d != 0)
                        //.sorted(comparatorAsc)
                        .collect(Collectors.toList());
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Only numbers are allowed");
            }
        } else {
            throw new IllegalArgumentException("Bad input articles");
        }

        return numbers;
    }


    /*
    * Resultat : meilleur couple de 10 dans chaque carton
    * Description : Prendre premier meilleur digit et lui rajouter le meilleur pour que le total avoisine au max 10
    *
    * @param articles Liste des articles à emballer
    * @return listColis Liste des colis crées
    */
    public Collection<Colis> emballerColis (List<Integer> articles) {
        Collection<Colis> listColis = new ArrayList<>();
        Colis colis = new Colis();

        while(articles.size() > 0 || (articles.isEmpty() && !colis.getArticles().isEmpty())) {

            // On ferme un carton quand il est soit plein soit dernier carton en cours
            if (colis.isFull() || (articles.isEmpty() && !colis.getArticles().isEmpty())) {
                listColis.add(colis);
                colis = new Colis();
            } else {
                Integer best = null;
                for (int i=0; i< articles.size(); i++) {

                    // Colis plein => arret recherche meilleure combinaison
                    if (colis.getTailleColis() + articles.get(i) == Constants.MAX_SIZE) {
                        best = i;
                        break;
                    }

                    // Premiere meilleure combinaison
                    if (colis.getTailleColis() + articles.get(i) <= Constants.MAX_SIZE && best == null ) {
                        best = i;
                    }

                    // Combinaison meilleure que la précédente
                    if (colis.getTailleColis() + articles.get(i) <= Constants.MAX_SIZE
                            && colis.getTailleColis() + articles.get(i) > colis.getTailleColis() + articles.get(best)) {
                        best = i;
                    }
                }

                // Bonne combinaison trouvée => ajout article dans le colis
                if (best != null) {
                    colis.addArticle(articles.get(best));
                    articles.remove(best.intValue());
                } else { // Ferme colis + ajout article dans un nouveau colis
                    listColis.add(colis);
                    colis = new Colis();
                    colis.addArticle(articles.get(0));
                    articles.remove(0);
                }
            }
        }

        return listColis;
    }

    /*
    * Description : Convertit la liste de colis en chaine de caracteres
    *
    * @param colisList listColis Liste des colis
    * @return
    */
    public String printColis(Collection<Colis> colisList) {
        StringBuilder stringBuilder = new StringBuilder();

        if (colisList != null) {
            colisList.stream().forEach(
                    colis -> {
                        if (!stringBuilder.toString().equals("")) {
                            stringBuilder.append(Constants.DELIMITER);
                        }
                        colis.getArticles().forEach(
                                article -> stringBuilder.append(article)
                        );
                    }
            );
        }

        return stringBuilder.toString();
    }

}
