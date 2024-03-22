package blog.hexaarchspring.adapters.in.rest.v1.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
public class ArticleDTO {
    private UUID id;
    private String title;
    private String content;
}
