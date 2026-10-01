package DTOs;

public class PagedResponseDto {

    private List<T> content;
    private int page;
    private int size;
    private long totalElements;

    public PagedResponseDto(Page<T> pageResult) {
        this.content = pageResult.getContent();
        this.page = pageResult.getNumber();
        this.size = pageResult.getSize();
        this.totalElements = pageResult.getTotalElements();
    }

}
