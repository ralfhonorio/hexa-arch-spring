package blog.hexaarchspring.adapters.in.rest.v1.dto;

import blog.hexaarchspring.application.core.domain.Article;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArticleMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public ArticleMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ArticleDTO toDTO(Article article) {
        return modelMapper.map(article, ArticleDTO.class);
    }

    public Article toDomain(ArticleDTO dto) {
        return modelMapper.map(dto, Article.class);
    }
}