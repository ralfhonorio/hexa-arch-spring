package blog.hexaarchspring.application.ports.out;

import blog.hexaarchspring.application.core.domain.Article;

public interface PostArticleOutputPort {

    Article createArticle(Article article);
}
