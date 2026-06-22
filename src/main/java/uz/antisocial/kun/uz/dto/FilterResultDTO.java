package uz.antisocial.kun.uz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class FilterResultDTO<E> {
    private List<E> content;
    private Long total;
}
