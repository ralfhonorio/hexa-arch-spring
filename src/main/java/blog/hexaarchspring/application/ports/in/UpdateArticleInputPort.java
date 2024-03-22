package blog.hexaarchspring.application.ports.in;

import blog.hexaarchspring.application.core.domain.Article;

public interface UpdateArticleInputPort {
    Article updateArticle(Article article);
}
