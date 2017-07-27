package pl.training.backend.common.model;

import lombok.Getter;

import java.util.List;

@Getter
public class ResultPage<T> {

    private List<T> content;
    private int pageNumber;
    private int totalPages;

    public ResultPage(List<T> content, int pageNumber, int totalPages) {
        this.content = content;
        this.pageNumber = pageNumber;
        this.totalPages = totalPages;
    }

}
