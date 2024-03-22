package blog.hexaarchspring.adapters.in.rest.v1;

import blog.hexaarchspring.adapters.in.rest.v1.dto.ArticleDTO;
import blog.hexaarchspring.adapters.in.rest.v1.dto.ArticleMapper;
import blog.hexaarchspring.application.core.domain.Article;
import blog.hexaarchspring.application.ports.in.FindArticleInputPort;
import blog.hexaarchspring.application.ports.in.PostArticleInputPort;
import blog.hexaarchspring.application.ports.in.RemoveArticleInputPort;
import blog.hexaarchspring.application.ports.in.UpdateArticleInputPort;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/articles")
public class ArticleResource {

    private final FindArticleInputPort findArticleInputPort;
    private final PostArticleInputPort postArticleInputPort;
    private final RemoveArticleInputPort removeArticleInputPort;
    private final UpdateArticleInputPort updateArticleInputPort;
    private final ArticleMapper articleMapper;

    public ArticleResource(FindArticleInputPort findArticleInputPort,
                           PostArticleInputPort postArticleInputPort,
                           RemoveArticleInputPort removeArticleInputPort,
                           UpdateArticleInputPort updateArticleInputPort,
                           ArticleMapper articleMapper) {
        this.findArticleInputPort = findArticleInputPort;
        this.postArticleInputPort = postArticleInputPort;
        this.removeArticleInputPort = removeArticleInputPort;
        this.updateArticleInputPort = updateArticleInputPort;
        this.articleMapper = articleMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDTO> getArticle(@PathVariable UUID id) {
        return findArticleInputPort.findById(id)
                .map(article -> ResponseEntity.ok(articleMapper.toDTO(article)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<ArticleDTO> getAllArticles() {
        return findArticleInputPort.findAll().stream()
                .map(articleMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ArticleDTO createArticle(@RequestBody ArticleDTO articleDTO) {
        Article article = articleMapper.toDomain(articleDTO);
        Article createdArticle = postArticleInputPort.createArticle(article);
        return articleMapper.toDTO(createdArticle);
    }

    @PutMapping("/{id}")
    public ArticleDTO updateArticle(@PathVariable UUID id, @RequestBody ArticleDTO articleDTO) {
        Article articleFound = findArticleInputPort.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Article not found"));

        Article articleToUpdate = articleMapper.toDomain(articleDTO);
        articleToUpdate.setId(articleFound.getId());
        Article updatedArticle = updateArticleInputPort.updateArticle(articleToUpdate);
        return articleMapper.toDTO(updatedArticle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable UUID id) {
        removeArticleInputPort.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }
}