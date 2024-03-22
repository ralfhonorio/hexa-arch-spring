package blog.hexaarchspring.adapters.out.repository.database.jpa.dto;

import blog.hexaarchspring.adapters.out.repository.database.jpa.entity.ArticleEntity;
import blog.hexaarchspring.application.core.domain.Article;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArticleEntityMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public ArticleEntityMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ArticleEntity toEntity(Article article) {
        return modelMapper.map(article, ArticleEntity.class);
    }

    public Article toDomain(ArticleEntity entity) {
        return modelMapper.map(entity, Article.class);
    }
}
