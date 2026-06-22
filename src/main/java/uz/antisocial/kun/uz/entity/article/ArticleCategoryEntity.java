package uz.antisocial.kun.uz.entity.article;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import uz.antisocial.kun.uz.entity.CategoryEntity;

@Getter
@Setter
@Entity
@Table(name = "article_category")
public class ArticleCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "category_id")
    private Integer categoryId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private CategoryEntity category;

    @Column(name = "article_id")
    private String articleId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id", insertable = false, updatable = false)
    private ArticleEntity article;
}
