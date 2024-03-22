package blog.hexaarchspring.application.ports.in;

import blog.hexaarchspring.application.core.domain.Article;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FindArticleInputPort {
    
    Optional<Article> findById(UUID id);
    
    List<Article> findAll();


}
