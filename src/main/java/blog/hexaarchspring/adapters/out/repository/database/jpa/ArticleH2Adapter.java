package blog.hexaarchspring.adapters.out.repository.database.jpa;


import blog.hexaarchspring.adapters.out.repository.database.jpa.dto.ArticleEntityMapper;
import blog.hexaarchspring.adapters.out.repository.database.jpa.entity.ArticleEntity;
import blog.hexaarchspring.application.core.domain.Article;
import blog.hexaarchspring.application.ports.out.FindArticleOutputPort;
import blog.hexaarchspring.application.ports.out.PostArticleOutputPort;
import blog.hexaarchspring.application.ports.out.RemoveArticleOutputPort;
import blog.hexaarchspring.application.ports.out.UpdateArticleOutputPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ArticleH2Adapter implements FindArticleOutputPort, PostArticleOutputPort, RemoveArticleOutputPort, UpdateArticleOutputPort {
    private final ArticleRepository articleRepository;
    private final ArticleEntityMapper articleEntityMapper;

    public ArticleH2Adapter(ArticleRepository articleRepository, ArticleEntityMapper articleEntityMapper) {
        this.articleRepository = articleRepository;
        this.articleEntityMapper = articleEntityMapper;
    }

    @Override
    public Article createArticle(Article article) {
        ArticleEntity entity = articleEntityMapper.toEntity(article);
        ArticleEntity savedEntity = articleRepository.save(entity);
        return articleEntityMapper.toDomain(savedEntity);
    }

    @Override
    public Article updateArticle(Article article) {
        ArticleEntity entity = articleEntityMapper.toEntity(article);
        ArticleEntity updatedEntity = articleRepository.save(entity);
        return articleEntityMapper.toDomain(updatedEntity);
    }

    @Override
    public Optional<Article> findById(UUID id) {
        Optional<ArticleEntity> entity = articleRepository.findById(id);
        return entity.map(articleEntityMapper::toDomain);
    }

    @Override
    public List<Article> findAll() {
        List<ArticleEntity> entities = articleRepository.findAll();
        return entities.stream()
                .map(articleEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteArticle(UUID id) {
        articleRepository.deleteById(id);
    }
}
