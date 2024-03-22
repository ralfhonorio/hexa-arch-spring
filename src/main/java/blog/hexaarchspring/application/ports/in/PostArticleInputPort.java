package blog.hexaarchspring.application.ports.in;

import blog.hexaarchspring.application.core.domain.Article;

public interface PostArticleInputPort {
    
    Article createArticle(Article article);
}
