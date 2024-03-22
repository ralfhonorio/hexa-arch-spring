package blog.hexaarchspring.application.ports.out;

import blog.hexaarchspring.application.core.domain.Article;

public interface UpdateArticleOutputPort {
    
    Article updateArticle(Article article);
}
